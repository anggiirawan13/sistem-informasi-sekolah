package com.sis.app.web.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TahunAjaranReq {

    @JsonProperty("id")
    private int id;

    @JsonProperty("periode")
    private int periode;

    @JsonProperty("tgl_mulai")
    private String tglMulai;

    @JsonProperty("tgl_akhir")
    private String tglAkhir;

    @JsonProperty("kurikulum")
    private String kurikulum;

}
