<template>
  <v-row>
    <!-- Input Fields -->
    <v-col cols="10" offset="1">
      <v-card class="mb-2">
        <v-toolbar :color="$vuetify.theme.themes.dark.primary" dark >TAMBAH TRANSAKSI</v-toolbar>
        <v-card-text>
          <v-alert v-if="message" color="red lighten-2" >{{ $t(message) }}</v-alert>
          <v-breadcrumbs :items="breadcrumbs" class="pa-0"></v-breadcrumbs>
          <v-form ref="form">
            <v-text-field
                name="kode_transaksi"
                label="Kode Transaksi"
                type="text"
                :rules="rules.kode_transaksi"
                v-model="form.kode_transaksi"
            />
            <v-text-field
                name="tgl_pembayaran"
                label="Tanggal Transaksi"
                type="date"
                :rules="rules.tgl_pembayaran"
                v-model="form.tgl_pembayaran"
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
          <v-btn to="/transaksi" :color="$vuetify.theme.themes.dark.accent" dark>Back</v-btn>
          <v-spacer />
          <v-btn @click="doSave" :color="$vuetify.theme.themes.dark.secondary" dark :loading="btnSaveDisable">Save</v-btn>
        </v-card-actions>
      </v-card>
    </v-col>
  </v-row>
</template>

<script>
export default {
  head: {
    title: "Tambah Transaksi",
  },
  data() {
    return {
      breadcrumbs: [
        { text: "Transaksi", to: "/transaksi", disabled: false, exact: true },
        { text: "Tambah", disabled: true },
      ],
      btnSaveDisable: false,
      message: "",
      status: ["Berhasil", "Pending", "Gagal"],
      form: {
        id_ta: 1,
        id_siswa: 1,
        id_pembayaran: 1,
        kode_transaksi: "",
        tgl_pembayaran: "",
        status: "",
      },
      rules: {
        kode_transaksi: [(v) => !!v || this.$t("FIELD_IS_REQUIRED", { field: "Kode Transaksi" })],
        tgl_pembayaran: [(v) => !!v || this.$t("FIELD_IS_REQUIRED", { field: "Tanggal Pembayaran" })],
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
          this.$axios.$post("/transaksi", this.form)
              .then((res) => {
                this.$router.push({
                  name: `transaksi___${this.$i18n.locale}`,
                  params: {
                    type: "success",
                    message: "ADD_SUCCESS",
                    title: this.form.kode_transaksi,
                  },
                });
              })
              .catch((err) => {
                this.$router.push({
                  name: `transaksi___${this.$i18n.locale}`,
                  params: {
                    type: "error",
                    message: "ADD_FAILED",
                    title: this.form.kode_transaksi,
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