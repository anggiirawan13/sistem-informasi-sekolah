<template>
  <v-row>
    <!-- Input Fields -->
    <v-col cols="10" offset="1">
      <v-card class="mb-2">
        <v-toolbar color="primary" dark>TAMBAH TAGIHAN SPP</v-toolbar>
        <v-card-text>
          <v-alert v-if="message" color="red lighten-2" dark>{{ $t(message) }}</v-alert>
          <v-breadcrumbs :items="breadcrumbs" class="pa-0"></v-breadcrumbs>
          <v-form ref="form">
            <v-text-field
                name="bulan"
                label="Bulan"
                type="number"
                :rules="rules.bulan"
                v-model="form.bulan"
            />
            <v-text-field
                name="jml_bayar"
                label="Jumlah Bayar"
                type="number"
                :rules="rules.jml_bayar"
                v-model="form.jml_bayar"
            />
            <v-text-field
                name="tgl_bayar"
                label="Tanggal Bayar"
                type="date"
                :rules="rules.tgl_bayar"
                v-model="form.tgl_bayar"
            />
            <v-select
                label="Status"
                :items="status"
                :rules="rules.status"
                v-model="form.status"
            />
          </v-form>
        </v-card-text>
        <v-card-actions>
          <v-btn to="/tagihan-spp" color="secondary">Back</v-btn>
          <v-spacer />
          <v-btn @click="doSave" color="primary" :loading="btnSaveDisable">Save</v-btn>
        </v-card-actions>
      </v-card>
    </v-col>
  </v-row>
</template>

<script>
export default {
  head: {
    title: "Tambah Tagihan SPP",
  },
  data() {
    return {
      breadcrumbs: [
        { text: "Tagihan SPP", to: "/tagihan-spp", disabled: false, exact: true },
        { text: "Tambah", disabled: true },
      ],
      btnSaveDisable: false,
      message: "",
      status: ["Berhasil", "Pending", "Gagal"],
      form: {
        id_transaksi: 2,
        id_siswa: 1,
        id_ta: 1,
        bulan: 0,
        jml_bayar: 0,
        tgl_bayar: "",
        status: "",
      },
      rules: {
        bulan: [(v) => !!v || this.$t("FIELD_IS_REQUIRED", { field: "Bulan" })],
        jml_bayar: [(v) => !!v || this.$t("FIELD_IS_REQUIRED", { field: "Jumlah Bayar" })],
        tgl_bayar: [(v) => !!v || this.$t("FIELD_IS_REQUIRED", { field: "Tanggal Bayar" })],
        status: [(v) => !!v || this.$t("FIELD_IS_REQUIRED", { field: "Status" })],
      },
    };
  },
  methods: {
    doSave() {
      this.message = "";

      if (this.$refs.form.validate()) {
        this.btnSaveDisable = true;

        try {
          this.$axios.$post("/tagihan-spp", this.form)
              .then((res) => {
                this.$router.push({
                  name: `tagihan-spp___${this.$i18n.locale}`,
                  params: {
                    type: "success",
                    message: "ADD_SUCCESS",
                    title: this.form.bulan,
                  },
                });
              })
              .catch((err) => {
                this.$router.push({
                  name: `tagihan-spp___${this.$i18n.locale}`,
                  params: {
                    type: "error",
                    message: "ADD_FAILED",
                    title: this.form.bulan,
                  },
                });
              })
        } catch (error) {
          console.error('Error:', error);
          this.message = "An error occurred while saving.";
        } finally {
          this.btnSaveDisable = false;
        }
      }
    }
  },
};
</script>
