package com.mibanco.es.clienteCDTDigital.gen.type;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("CabeceraSalidaIBSType")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-05-24T10:13:09.004225-05:00[America/Bogota]")
public class CabeceraSalidaIBSType   {
  private @Valid Long id;
  private @Valid String rqUID;
  private @Valid Integer codError;
  private @Valid String descError;

  /**
   **/
  public CabeceraSalidaIBSType id(Long id) {
    this.id = id;
    return this;
  }

  
  @JsonProperty("id")
  public Long getId() {
    return id;
  }

  @JsonProperty("id")
  public void setId(Long id) {
    this.id = id;
  }

  /**
   **/
  public CabeceraSalidaIBSType rqUID(String rqUID) {
    this.rqUID = rqUID;
    return this;
  }

  
  @JsonProperty("rqUID")
  public String getRqUID() {
    return rqUID;
  }

  @JsonProperty("rqUID")
  public void setRqUID(String rqUID) {
    this.rqUID = rqUID;
  }

  /**
   **/
  public CabeceraSalidaIBSType codError(Integer codError) {
    this.codError = codError;
    return this;
  }

  
  @JsonProperty("codError")
  public Integer getCodError() {
    return codError;
  }

  @JsonProperty("codError")
  public void setCodError(Integer codError) {
    this.codError = codError;
  }

  /**
   **/
  public CabeceraSalidaIBSType descError(String descError) {
    this.descError = descError;
    return this;
  }

  
  @JsonProperty("descError")
  public String getDescError() {
    return descError;
  }

  @JsonProperty("descError")
  public void setDescError(String descError) {
    this.descError = descError;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CabeceraSalidaIBSType cabeceraSalidaIBSType = (CabeceraSalidaIBSType) o;
    return Objects.equals(this.id, cabeceraSalidaIBSType.id) &&
        Objects.equals(this.rqUID, cabeceraSalidaIBSType.rqUID) &&
        Objects.equals(this.codError, cabeceraSalidaIBSType.codError) &&
        Objects.equals(this.descError, cabeceraSalidaIBSType.descError);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, rqUID, codError, descError);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CabeceraSalidaIBSType {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    rqUID: ").append(toIndentedString(rqUID)).append("\n");
    sb.append("    codError: ").append(toIndentedString(codError)).append("\n");
    sb.append("    descError: ").append(toIndentedString(descError)).append("\n");
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

