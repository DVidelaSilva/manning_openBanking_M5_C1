package io.manning.openbanking.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.manning.openbanking.models.OtherFeeTypeInner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.constraints.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Details about any caps (maximum charges) that apply to a particular fee/charge
 */

@Schema(name = "OverdraftFeeChargeCap", description = "Details about any caps (maximum charges) that apply to a particular fee/charge")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-11-20T16:37:37.728783-03:00[America/Santiago]", comments = "Generator version: 7.10.0")
public class OverdraftFeeChargeCap {

  /**
   * Overdraft fee type
   */
  public enum FeeTypeEnum {
    ARRANGED_OVERDRAFT("ArrangedOverdraft"),
    
    EMERGENCY_BORROWING("EmergencyBorrowing"),
    
    BORROWING_ITEM("BorrowingItem"),
    
    OVERDRAFT_RENEWAL("OverdraftRenewal"),
    
    ANNUAL_REVIEW("AnnualReview"),
    
    OVERDRAFT_SETUP("OverdraftSetup"),
    
    SURCHARGE("Surcharge"),
    
    TEMP_OVERDRAFT("TempOverdraft"),
    
    UNAUTHORISED_BORROWING("UnauthorisedBorrowing"),
    
    UNAUTHORISED_PAID_TRANS("UnauthorisedPaidTrans"),
    
    OTHER("Other"),
    
    UNAUTHORISED_UNPAID_TRANS("UnauthorisedUnpaidTrans");

    private String value;

    FeeTypeEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static FeeTypeEnum fromValue(String value) {
      for (FeeTypeEnum b : FeeTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  
  private List<FeeTypeEnum> feeType = new ArrayList<>();

  private Boolean overdraftControlIndicator;

  /**
   * Indicates that this is the minimum/ maximum fee/charge that can be applied by the financial institution
   */
  public enum MinMaxTypeEnum {
    MINIMUM("Minimum"),
    
    MAXIMUM("Maximum");

    private String value;

    MinMaxTypeEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static MinMaxTypeEnum fromValue(String value) {
      for (MinMaxTypeEnum b : MinMaxTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private MinMaxTypeEnum minMaxType;

  private Float feeCapOccurrence;

  private String feeCapAmount;

  /**
   * Period e.g. day, week, month etc. for which the fee/charge is capped
   */
  public enum CappingPeriodEnum {
    ACADEMIC_TERM("AcademicTerm"),
    
    DAY("Day"),
    
    HALF_YEAR("Half Year"),
    
    MONTH("Month"),
    
    QUARTER("Quarter"),
    
    WEEK("Week"),
    
    YEAR("Year");

    private String value;

    CappingPeriodEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static CappingPeriodEnum fromValue(String value) {
      for (CappingPeriodEnum b : CappingPeriodEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private CappingPeriodEnum cappingPeriod;

  
  private List<String> notes = new ArrayList<>();

  
  private List<OtherFeeTypeInner> otherFeeType = new ArrayList<>();

  public OverdraftFeeChargeCap() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public OverdraftFeeChargeCap(List<FeeTypeEnum> feeType, MinMaxTypeEnum minMaxType) {
    this.feeType = feeType;
    this.minMaxType = minMaxType;
  }

  public OverdraftFeeChargeCap feeType(List<FeeTypeEnum> feeType) {
    this.feeType = feeType;
    return this;
  }

  public OverdraftFeeChargeCap addFeeTypeItem(FeeTypeEnum feeTypeItem) {
    if (this.feeType == null) {
      this.feeType = new ArrayList<>();
    }
    this.feeType.add(feeTypeItem);
    return this;
  }

  /**
   * Fee/charge type which is being capped
   * @return feeType
   */
  @NotNull
  @Schema(name = "FeeType", description = "Fee/charge type which is being capped", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("FeeType")
  public List<FeeTypeEnum> getFeeType() {
    return feeType;
  }

  public void setFeeType(List<FeeTypeEnum> feeType) {
    this.feeType = feeType;
  }

  public OverdraftFeeChargeCap overdraftControlIndicator(Boolean overdraftControlIndicator) {
    this.overdraftControlIndicator = overdraftControlIndicator;
    return this;
  }

  /**
   * Specifies for the overdraft control feature/benefit
   * @return overdraftControlIndicator
   */
  
  @Schema(name = "OverdraftControlIndicator", description = "Specifies for the overdraft control feature/benefit", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("OverdraftControlIndicator")
  public Boolean getOverdraftControlIndicator() {
    return overdraftControlIndicator;
  }

  public void setOverdraftControlIndicator(Boolean overdraftControlIndicator) {
    this.overdraftControlIndicator = overdraftControlIndicator;
  }

  public OverdraftFeeChargeCap minMaxType(MinMaxTypeEnum minMaxType) {
    this.minMaxType = minMaxType;
    return this;
  }

  /**
   * Indicates that this is the minimum/ maximum fee/charge that can be applied by the financial institution
   * @return minMaxType
   */
  @NotNull
  @Schema(name = "MinMaxType", description = "Indicates that this is the minimum/ maximum fee/charge that can be applied by the financial institution", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("MinMaxType")
  public MinMaxTypeEnum getMinMaxType() {
    return minMaxType;
  }

  public void setMinMaxType(MinMaxTypeEnum minMaxType) {
    this.minMaxType = minMaxType;
  }

  public OverdraftFeeChargeCap feeCapOccurrence(Float feeCapOccurrence) {
    this.feeCapOccurrence = feeCapOccurrence;
    return this;
  }

  /**
   * fee/charges are captured dependent on the number of occurrences rather than capped at a particular amount
   * @return feeCapOccurrence
   */
  
  @Schema(name = "FeeCapOccurrence", description = "fee/charges are captured dependent on the number of occurrences rather than capped at a particular amount", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("FeeCapOccurrence")
  public Float getFeeCapOccurrence() {
    return feeCapOccurrence;
  }

  public void setFeeCapOccurrence(Float feeCapOccurrence) {
    this.feeCapOccurrence = feeCapOccurrence;
  }

  public OverdraftFeeChargeCap feeCapAmount(String feeCapAmount) {
    this.feeCapAmount = feeCapAmount;
    return this;
  }

  /**
   * Cap amount charged for a fee/charge
   * @return feeCapAmount
   */
  
  @Schema(name = "FeeCapAmount", description = "Cap amount charged for a fee/charge", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("FeeCapAmount")
  public String getFeeCapAmount() {
    return feeCapAmount;
  }

  public void setFeeCapAmount(String feeCapAmount) {
    this.feeCapAmount = feeCapAmount;
  }

  public OverdraftFeeChargeCap cappingPeriod(CappingPeriodEnum cappingPeriod) {
    this.cappingPeriod = cappingPeriod;
    return this;
  }

  /**
   * Period e.g. day, week, month etc. for which the fee/charge is capped
   * @return cappingPeriod
   */
  
  @Schema(name = "CappingPeriod", description = "Period e.g. day, week, month etc. for which the fee/charge is capped", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("CappingPeriod")
  public CappingPeriodEnum getCappingPeriod() {
    return cappingPeriod;
  }

  public void setCappingPeriod(CappingPeriodEnum cappingPeriod) {
    this.cappingPeriod = cappingPeriod;
  }

  public OverdraftFeeChargeCap notes(List<String> notes) {
    this.notes = notes;
    return this;
  }

  public OverdraftFeeChargeCap addNotesItem(String notesItem) {
    if (this.notes == null) {
      this.notes = new ArrayList<>();
    }
    this.notes.add(notesItem);
    return this;
  }

  /**
   * Notes related to Overdraft fee charge cap
   * @return notes
   */
  
  @Schema(name = "Notes", description = "Notes related to Overdraft fee charge cap", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("Notes")
  public List<String> getNotes() {
    return notes;
  }

  public void setNotes(List<String> notes) {
    this.notes = notes;
  }

  public OverdraftFeeChargeCap otherFeeType(List<OtherFeeTypeInner> otherFeeType) {
    this.otherFeeType = otherFeeType;
    return this;
  }

  public OverdraftFeeChargeCap addOtherFeeTypeItem(OtherFeeTypeInner otherFeeTypeItem) {
    if (this.otherFeeType == null) {
      this.otherFeeType = new ArrayList<>();
    }
    this.otherFeeType.add(otherFeeTypeItem);
    return this;
  }

  /**
   * Other fee type code which is not available in the standard code set
   * @return otherFeeType
   */
  
  @Schema(name = "OtherFeeType", description = "Other fee type code which is not available in the standard code set", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("OtherFeeType")
  public List<OtherFeeTypeInner> getOtherFeeType() {
    return otherFeeType;
  }

  public void setOtherFeeType(List<OtherFeeTypeInner> otherFeeType) {
    this.otherFeeType = otherFeeType;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OverdraftFeeChargeCap overdraftFeeChargeCap = (OverdraftFeeChargeCap) o;
    return Objects.equals(this.feeType, overdraftFeeChargeCap.feeType) &&
        Objects.equals(this.overdraftControlIndicator, overdraftFeeChargeCap.overdraftControlIndicator) &&
        Objects.equals(this.minMaxType, overdraftFeeChargeCap.minMaxType) &&
        Objects.equals(this.feeCapOccurrence, overdraftFeeChargeCap.feeCapOccurrence) &&
        Objects.equals(this.feeCapAmount, overdraftFeeChargeCap.feeCapAmount) &&
        Objects.equals(this.cappingPeriod, overdraftFeeChargeCap.cappingPeriod) &&
        Objects.equals(this.notes, overdraftFeeChargeCap.notes) &&
        Objects.equals(this.otherFeeType, overdraftFeeChargeCap.otherFeeType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(feeType, overdraftControlIndicator, minMaxType, feeCapOccurrence, feeCapAmount, cappingPeriod, notes, otherFeeType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OverdraftFeeChargeCap {\n");
    sb.append("    feeType: ").append(toIndentedString(feeType)).append("\n");
    sb.append("    overdraftControlIndicator: ").append(toIndentedString(overdraftControlIndicator)).append("\n");
    sb.append("    minMaxType: ").append(toIndentedString(minMaxType)).append("\n");
    sb.append("    feeCapOccurrence: ").append(toIndentedString(feeCapOccurrence)).append("\n");
    sb.append("    feeCapAmount: ").append(toIndentedString(feeCapAmount)).append("\n");
    sb.append("    cappingPeriod: ").append(toIndentedString(cappingPeriod)).append("\n");
    sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
    sb.append("    otherFeeType: ").append(toIndentedString(otherFeeType)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

