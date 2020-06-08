package com.project.api.search.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Highlight {

    @ApiModelProperty(dataType = "List", example = "[Hugo, Gabriel]")
    private List<String> lastName;

    @ApiModelProperty(dataType = "List", example = "[Tom, Teddy]")
    private List<String> firstName;

    @ApiModelProperty(dataType = "List", example = "[FR, SE]")
    private List<String> country;

    @ApiModelProperty(dataType = "List", example = "[tom.hugo@lyreco.com, gabriel.teddy@lyreco.com]")
    private List<String> email;

    @ApiModelProperty(dataType = "List", example = "[tom.hugo@lyreco.com, gabriel.teddy@lyreco.com]")
    @JsonProperty("email.full_email")
    private List<String> fullEmail;

    @ApiModelProperty(dataType = "List", example = "[+4712345678, +4787654321]")
    private List<String> phone;

    @ApiModelProperty(dataType = "List", example = "[lyreco, capgemini]")
    @JsonProperty("company.name")
    private List<String> companyName;

    @ApiModelProperty(dataType = "List", example = "[paris, lyon]")
    @JsonProperty("company.city")
    private List<String> companyCity;

    @ApiModelProperty(dataType = "List", example = "[75008, 75016]")
    @JsonProperty("company.postalCode")
    private List<String> companyPostalCode;

    @ApiModelProperty(dataType = "List", example = "[HR]")
    @JsonProperty("company.postalCode.department")
    private List<String> companyDepartment;

    @ApiModelProperty(dataType = "List", example = "75008, 75016")
    @JsonProperty("addresses.postalCode")
    private List<String> addressPostalCode;

    @ApiModelProperty(dataType = "List", example = "[HR]")
    @JsonProperty("addresses.postalCode.department")
    private List<String> addressDepartment;

    @ApiModelProperty(dataType = "List", example = "[Rue de la République, Rue du Moulin]")
    @JsonProperty("addresses.street")
    private List<String> addressStreet;

    @ApiModelProperty(dataType = "List", example = "[FR, SE]")
    @JsonProperty("addresses.country")
    private List<String> addressCountry;

    @ApiModelProperty(dataType = "List", example = "[paris, lyon]")
    @JsonProperty("addresses.city")
    private List<String> addressCity;

    @ApiModelProperty(dataType = "List", example = "[0000459463]")
    @JsonProperty("addresses.accountId")
    private List<String> addressAccountId;

    @ApiModelProperty(dataType = "List", example = "[0000459463]")
    @JsonProperty("addresses.accountId.pattern")
    private List<String> addressAccountIdPattern;

    @ApiModelProperty(dataType = "List", example = "[0000459500]")
    @JsonProperty("addresses.associatedSoldTo")
    private List<String> addressAssociatedSoldTo;

    @ApiModelProperty(dataType = "List", example = "[0000459500]")
    @JsonProperty("addresses.associatedSoldTo.pattern")
    private List<String> addressAssociatedSoldToPattern;

    @ApiModelProperty(dataType = "List", example = "[DELIVERY_ADDRESS]")
    @JsonProperty("addresses.addressTypes")
    private List<String> addressAddressTypes;

    @ApiModelProperty(dataType = "List", example = "[MR PHILIPPE MONIN]")
    @JsonProperty("addresses.legalName1")
    private List<String> legalName1;

    @ApiModelProperty(dataType = "List", example = "[legalName2]")
    @JsonProperty("addresses.legalName2")
    private List<String> legalName2;

    @ApiModelProperty(dataType = "List", example = "[legalName3]")
    @JsonProperty("addresses.legalName3")
    private List<String> legalName3;
}
