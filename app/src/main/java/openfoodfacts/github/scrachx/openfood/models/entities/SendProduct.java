package openfoodfacts.github.scrachx.openfood.models.entities;

import android.text.TextUtils;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Transient;

import java.io.Serializable;

import openfoodfacts.github.scrachx.openfood.models.ProductImageField;
import openfoodfacts.github.scrachx.openfood.network.ApiFields;
import openfoodfacts.github.scrachx.openfood.utils.Utils;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Entity(indexes = {@Index(value = "barcode", unique = true)})
public class SendProduct implements Serializable {
    private static final long serialVersionUID = 2L;
    @Id
    private Long id;
    @JsonProperty(ApiFields.Keys.BARCODE)
    private String barcode;
    private String lang;
    @JsonProperty(ApiFields.Keys.PRODUCT_NAME)
    private String name;
    private String brands;
    @JsonIgnore
    private String weight;
    @JsonIgnore
    private String imguploadFront;
    @JsonIgnore
    private String imguploadIngredients;
    @JsonIgnore
    private String imguploadNutrition;
    @JsonIgnore
    private String imguploadPackaging;
    @JsonProperty(ApiFields.Keys.USER_ID)
    @Transient
    private String userID;
    @JsonIgnore
    @Property(nameInDb = "weight_unit")
    private String weightUnit = "g";
    @Transient
    private String password;

    public SendProduct() {
    }

    @Generated(hash = 1120947740)
    public SendProduct(Long id, String barcode, String lang, String name, String brands, String weight, String imguploadFront, String imguploadIngredients,
                       String imguploadNutrition, String imguploadPackaging, String weightUnit) {
        this.id = id;
        this.barcode = barcode;
        this.lang = lang;
        this.name = name;
        this.brands = brands;
        this.weight = weight;
        this.imguploadFront = imguploadFront;
        this.imguploadIngredients = imguploadIngredients;
        this.imguploadNutrition = imguploadNutrition;
        this.imguploadPackaging = imguploadPackaging;
        this.weightUnit = weightUnit;
    }

    @Keep
    public SendProduct(@NonNull SendProduct sp) {
        this.barcode = sp.getBarcode();
        this.name = sp.getName();
        this.brands = sp.getBrands();
        this.weight = sp.getWeight();
        this.weightUnit = sp.getWeightUnit();
        this.imguploadFront = sp.getImguploadFront();
        this.imguploadIngredients = sp.getImguploadIngredients();
        this.imguploadNutrition = sp.getImguploadNutrition();
        this.imguploadPackaging = sp.getImguploadPackaging();
        this.lang = sp.getLang();
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getWeightUnit() {
        return weightUnit;
    }

    public void setWeightUnit(String weightUnit) {
        this.weightUnit = weightUnit;
    }

    public String getQuantity() {
        if (weight == null || weight.length() == 0) {
            return null;
        }

        return this.weight + " " + this.weightUnit;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getImguploadFront() {
        return imguploadFront;
    }

    public void setImguploadFront(String imguploadFront) {
        this.imguploadFront = imguploadFront;
    }

    public String getBrands() {
        return brands;
    }

    public void setBrands(String brands) {
        this.brands = brands;
    }

    public String getImguploadIngredients() {
        return imguploadIngredients;
    }

    public void setImguploadIngredients(String imguploadIngredients) {
        this.imguploadIngredients = imguploadIngredients;
    }

    public String getImguploadNutrition() {
        return imguploadNutrition;
    }

    public void setImguploadNutrition(String imguploadNutrition) {
        this.imguploadNutrition = imguploadNutrition;
    }

    public String getImguploadPackaging() {
        return imguploadPackaging;
    }

    public void setImguploadPackaging(String imguploadPackaging) {
        this.imguploadPackaging = imguploadPackaging;
    }

    /**
     * Compress the image according to the {@link ProductImageField}.
     * Add a "_small" prefix in the image name after the compression
     */
    public void compress(@NonNull ProductImageField field) {
        switch (field) {
            case NUTRITION:
                this.imguploadNutrition = Utils.compressImage(this.imguploadNutrition);
                break;
            case INGREDIENTS:
                this.imguploadIngredients = Utils.compressImage(this.imguploadIngredients);
                break;
            case PACKAGING:
                this.imguploadPackaging = Utils.compressImage(this.imguploadPackaging);
                break;
            case FRONT:
                this.imguploadFront = Utils.compressImage(this.imguploadFront);
                break;
            default:
                //nothing to do
                break;
        }
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isEqual(@NonNull SendProduct sp) {
        return TextUtils.equals(this.barcode, sp.getBarcode())
            && TextUtils.equals(this.name, sp.getName())
            && TextUtils.equals(this.brands, sp.getBrands())
            && TextUtils.equals(this.weight, sp.getWeight())
            && TextUtils.equals(this.weightUnit, sp.getWeightUnit())
            && TextUtils.equals(this.imguploadFront, sp.getImguploadFront())
            && TextUtils.equals(this.imguploadNutrition, sp.getImguploadNutrition())
            && TextUtils.equals(this.imguploadPackaging, sp.getImguploadPackaging())
            && TextUtils.equals(this.imguploadIngredients, sp.getImguploadIngredients());
    }
}