package com.celebritiesGathering.entity;

import com.celebritiesGathering.constants.RoleType;
import com.celebritiesGathering.security.JPACryptoConverter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

/**
 * @author lli.chen
 */
@Entity
@Data
public class Account extends IEntity {

    @ApiModelProperty(value = "用户名")
    @Column(unique = true, nullable = false)
    private String loginName;

    @ApiModelProperty(value = "密码")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Convert(converter = JPACryptoConverter.class)
    private String password = "123456";

    @ApiModelProperty(value = "微信号") //这两个应该是非必要的，暂时写在这里了
    private String weChat;

    @ApiModelProperty(value = "手机号")
    private String phoneNum;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @JsonIgnore
    public String getAuthority() {
        return "ROLE_ACCOUNT";
    }
}
