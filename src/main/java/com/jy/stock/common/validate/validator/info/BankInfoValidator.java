package com.jy.stock.common.validate.validator.info;

import com.jy.stock.common.validate.annotation.info.ValidateBankInfo;
import com.jy.stock.model.request.info.AddModifyCustomerInfoReq;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * @author liaojunyao
 */
public class BankInfoValidator implements ConstraintValidator<ValidateBankInfo, AddModifyCustomerInfoReq> {

    private String bankName;

    private String bankCardId;

    private String taxpayerId;

    @Override
    public void initialize(ValidateBankInfo constraintAnnotation) {
        bankName = constraintAnnotation.bankName();
        bankCardId = constraintAnnotation.bankCardId();
        taxpayerId = constraintAnnotation.taxpayerId();
    }

    @Override
    public boolean isValid(AddModifyCustomerInfoReq request, ConstraintValidatorContext constraintValidatorContext) {
        if(request == null) {
            return false;
        }
        try {
            String bankNameVal = BeanUtils.getProperty(request, bankName);
            String bankCardIdVal = BeanUtils.getProperty(request, bankCardId);
            String taxpayerIdVal = BeanUtils.getProperty(request, taxpayerId);
            if(StringUtils.isAllBlank(bankNameVal, bankCardIdVal, taxpayerIdVal)) {
                return true;
            }

            return StringUtils.isNoneBlank(bankNameVal, bankCardIdVal, taxpayerIdVal);
        } catch (Exception ex) {
            return false;
        }
    }

}