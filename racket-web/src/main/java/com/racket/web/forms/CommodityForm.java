package com.racket.web.forms;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.springframework.core.style.ToStringCreator;

import com.racket.commons.models.RacketCommodity;
import com.racket.commons.models.RentalDetails;
import com.racket.commons.models.support.ChargingMethod;
import com.racket.commons.models.support.CommodityType;
import com.racket.commons.models.support.RoundUp;

/**
 * @author Mark
 */
public class CommodityForm {

	private Long racketId;

	private long id;
	
	@NotNull
	private String name;

	@NotNull
	private String description;
	
	@NotNull
	private CommodityType type;

	private BigDecimal price = BigDecimal.valueOf(0);
	private String unit;

	//rental details
	private RoundUp roundUp = RoundUp.NONE;
	private ChargingMethod chargingMethod = ChargingMethod.PER_MINUTE;
	private BigDecimal pricePerMinute = BigDecimal.valueOf(0);
	private BigDecimal minimumCharge = BigDecimal.valueOf(0);

	@Override
	public String toString() {
		return new ToStringCreator(this)
			.append("racketId", racketId)
			.append("id", id)
			.append("name", name)
			.append("description", description)
			.append("type", type)
			.append("price", price)
			.append("unit", unit)
			.toString();
	}
	
	public RacketCommodity toCommodity() {
		RacketCommodity commodity = new RacketCommodity();
		commodity.setDescription(description);
		commodity.setName(name);
		commodity.setType(type);
		commodity.setPrice(price);
		commodity.setUnit(unit);
		
		if (id != 0) {
			commodity.setId(id);
		}

		//rental details
		RentalDetails rentalDetails = new RentalDetails();
		rentalDetails.setChargingMethod(chargingMethod);
		rentalDetails.setPricePerMinute(pricePerMinute);
		rentalDetails.setRoundUp(roundUp);
		rentalDetails.setMinimumCharge(minimumCharge);
		commodity.setRentalDetails(rentalDetails);

		return commodity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CommodityType getType() {
		return type;
	}

	public void setType(CommodityType type) {
		this.type = type;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Long getRacketId() {
		return racketId;
	}

	public void setRacketId(Long racketId) {
		this.racketId = racketId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

    public ChargingMethod getChargingMethod() {
        return chargingMethod;
    }

    public void setChargingMethod(ChargingMethod chargingMethod) {
        this.chargingMethod = chargingMethod;
    }

    public BigDecimal getPricePerMinute() {
        return pricePerMinute;
    }

    public void setPricePerMinute(BigDecimal pricePerMinute) {
        this.pricePerMinute = pricePerMinute;
    }

    public RoundUp getRoundUp() {
        return roundUp;
    }

    public void setRoundUp(RoundUp roundUp) {
        this.roundUp = roundUp;
    }

	public BigDecimal getMinimumCharge() {
		return minimumCharge;
	}

	public void setMinimumCharge(BigDecimal minimumCharge) {
		this.minimumCharge = minimumCharge;
	}
	
}
