
package com.example.mdarifur.weatherdata.model.ForecastTenday;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Features {

    @SerializedName("forecast10day")
    @Expose
    private Integer forecast10day;

    /**
     * 
     * @return
     *     The forecast10day
     */
    public Integer getForecast10day() {
        return forecast10day;
    }

    /**
     * 
     * @param forecast10day
     *     The forecast10day
     */
    public void setForecast10day(Integer forecast10day) {
        this.forecast10day = forecast10day;
    }

}
