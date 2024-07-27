package com.jy.stock.service.system.impl;

import com.jy.stock.common.util.AssertUtils;
import com.jy.stock.common.util.HashUtils;
import com.jy.stock.common.util.system.PasswordGenerator;
import com.jy.stock.enums.system.UserRoleEnum;
import com.jy.stock.model.dto.system.UserRoleDTO;
import com.jy.stock.model.entity.system.UserInfo;
import com.jy.stock.service.system.UserInfoService;
import com.jy.stock.service.system.UserRoleService;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.List;

/**
 * @author liaojunyao
 */
@Slf4j
@Service
public class UserFacade {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private PlatformTransactionManager transactionManager;

    @PostConstruct
    public void init() {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

        TransactionStatus status = transactionManager.getTransaction(def);
        try {
            long count = userInfoService.countAllUsers();
            if (count > 0) {
                return;
            }
            log.info("No user found, initializing default user");

            String salt = HashUtils.randomSalt();
            String password = PasswordGenerator.generatePassword(8);
            String encryptedPassword = HashUtils.sha256(password + salt);
            UserInfo admin = UserInfo.builder()
                    .userName("admin")
                    .encryptedPassword(encryptedPassword)
                    .salt(salt).build();
            boolean isSaved = userInfoService.save(admin);
            AssertUtils.isTrue(isSaved, "init.default.user.failed");
            if (!isSaved) {
                throw new RuntimeException("Failed to save default user");
            }
            List<UserRoleDTO> roles = userRoleService.addModifyUserRoles(admin.getId(), List.of(UserRoleEnum.ADMIN.getCode()));
            AssertUtils.isTrue(CollectionUtils.isNotEmpty(roles), "init.default.user.failed");
            transactionManager.commit(status);
            log.info("Default user initialized successfully, username: {}, password: {}", admin.getUserName(), password);
        } catch (Exception e) {
            transactionManager.rollback(status);
            log.error("Failed to initialize default user", e);
        }

    }

}
