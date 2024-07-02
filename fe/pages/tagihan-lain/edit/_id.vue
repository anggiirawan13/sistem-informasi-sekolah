<template>
  <v-row>
    <!-- Input Fields -->
    <v-col cols="10" offset="1">
      <v-card class="mb-2">
        <v-toolbar :color="$vuetify.theme.themes.dark.secondary" dark >UBAH TAGIHAN Lain</v-toolbar>
        <v-card-text>
          <v-alert v-if="message" color="red lighten-2" >{{ $t(message) }}</v-alert>
          <v-breadcrumbs :items="breadcrumbs" class="pa-0"></v-breadcrumbs>
          <v-form ref="form">
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
          <v-btn to="/tagihan-lain" :color="$vuetify.theme.themes.dark.accent" dark>Back</v-btn>
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
    title: "Ubah Tagihan Lain",
  },
  asyncData({ params }) {
    return {
      id: params.id,
    }
  },
  data() {
    return {
      breadcrumbs: [
        { text: "Tagihan Lain", to: "/tagihan-lain", disabled: false, exact: true },
        { text: "Ubah", disabled: true },
      ],
      btnSaveDisable: false,
      message: "",
      status: ["Berhasil", "Pending", "Gagal"],
      form: {
        id_komponen: 1,
        id_transaksi: 2,
        id_siswa: 1,
        id_ta: 1,
        tgl_bayar: "",
        status: "",
      },
      rules: {
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
          this.form.id = this.id
          this.$axios.$post("/tagihan-lain", this.form)
              .then((res) => {
                this.$router.push({
                  name: `tagihan-lain___${this.$i18n.locale}`,
                  params: {
                    type: "success",
                    message: "ADD_SUCCESS",
                    title: this.form.tgl_bayar,
                  },
                });
              })
              .catch((err) => {
                this.$router.push({
                  name: `tagihan-lain___${this.$i18n.locale}`,
                  params: {
                    type: "error",
                    message: "ADD_FAILED",
                    title: this.form.tgl_bayar,
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
    },
    getData() {
      try {
        this.$axios.$get(`/tagihan-lain/${this.id}`)
            .then((res) => {
              const {data} = res;

              this.form.tgl_bayar = data.tgl_bayar,
                  this.form.jml_bayar = data.jml_bayar,
                  this.form.tgl_bayar = data.tgl_bayar,
                  this.form.status = data.status
            })
      } catch (error) {
        console.error('Error:', error);
      }
    },
  },
  async mounted() {
    this.getData();
  },
};
</script>
