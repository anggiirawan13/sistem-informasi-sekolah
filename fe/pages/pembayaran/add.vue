<template>
  <v-row>
    <!-- Input Fields -->
    <v-col cols="10" offset="1">
      <v-card class="mb-2">
        <v-toolbar :color="$vuetify.theme.themes.dark.primary" dark >TAMBAH PEMBAYARAN</v-toolbar>
        <v-card-text>
          <v-alert v-if="message" color="red lighten-2" >{{ $t(message) }}</v-alert>
          <v-breadcrumbs :items="breadcrumbs" class="pa-0"></v-breadcrumbs>
          <v-form ref="form">
            <v-text-field
                name="tgl_pembayaran"
                label="Tanggal Pembayaran"
                type="date"
                :rules="rules.tgl_pembayaran"
                v-model="form.tgl_pembayaran"
            />
            <v-text-field
                name="jumlah_bayar"
                label="Jumlah Bayar"
                type="number"
                :rules="rules.jumlah_bayar"
                v-model="form.jumlah_bayar"
            />
            <v-text-field
                name="metode_bayar"
                label="Metode Bayar"
                type="number"
                :rules="rules.metode_bayar"
                v-model="form.metode_bayar"
            />
          </v-form>
        </v-card-text>
        <v-card-actions>
          <v-btn to="/pembayaran" :color="$vuetify.theme.themes.dark.accent" dark>Back</v-btn>
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
    title: "Tambah Pembayaran",
  },
  data() {
    return {
      breadcrumbs: [
        { text: "Pembayaran", to: "/pembayaran", disabled: false, exact: true },
        { text: "Tambah", disabled: true },
      ],
      btnSaveDisable: false,
      message: "",
      form: {
        id_ta: 2,
        id_siswa: 3,
        tgl_pembayaran: "",
        jumlah_bayar: "",
        metode_bayar: "",
      },
      rules: {
        tgl_pembayaran: [(v) => !!v || this.$t("FIELD_IS_REQUIRED", { field: "Tanggal Pembayaran" })],
        jumlah_bayar: [(v) => !!v || this.$t("FIELD_IS_REQUIRED", { field: "Jumlah Bayar" })],
        metode_bayar: [(v) => !!v || this.$t("FIELD_IS_REQUIRED", { field: "Metode Bayar" })],
      },
      editedItem: null,
    };
  },
  methods: {
    doSave() {
      this.message = "";

      if (this.$refs.form.validate()) {
        this.btnSaveDisable = true;

        try {
          this.$axios.$post("/pembayaran", this.form)
              .then((res) => {
                this.$router.push({
                  name: `pembayaran___${this.$i18n.locale}`,
                  params: {
                    type: "success",
                    message: "ADD_SUCCESS",
                    title: this.form.jumlah_bayar,
                  },
                });
              })
              .catch((err) => {
                this.$router.push({
                  name: `pembayaran___${this.$i18n.locale}`,
                  params: {
                    type: "error",
                    message: "ADD_FAILED",
                    title: this.form.jumlah_bayar,
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
