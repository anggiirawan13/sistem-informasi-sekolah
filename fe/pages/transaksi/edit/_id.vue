<template>
  <v-row>
    <!-- Input Fields -->
    <v-col cols="10" offset="1">
      <v-card class="mb-2">
        <v-toolbar :color="$vuetify.theme.themes.dark.primary" dark >UBAH TAGIHAN SPP</v-toolbar>
        <v-card-text>
          <v-alert v-if="message" color="red lighten-2" >{{ $t(message) }}</v-alert>
          <v-breadcrumbs :items="breadcrumbs" class="pa-0"></v-breadcrumbs>
          <v-form ref="form">
            <v-text-field
                name="bulan"
                label="Kode Transaksi"
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
                v-model="form.id_ta"
                :items="tahun_ajaran"
                label="Tahun Ajaran"
                :rules="rules.tahun_ajaran"
            ></v-select>
            <v-select
                label="Status"
                :items="status"
                :rules="rules.status"
                v-model="form.status"
            />
          </v-form>
        </v-card-text>
        <v-card-actions>
          <v-btn to="/tagihan-spp" :color="$vuetify.theme.themes.dark.accent" dark>Back</v-btn>
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
    title: "Ubah Tagihan SPP",
  },
  asyncData({ params }) {
    return {
      id: params.id,
    }
  },
  data() {
    return {
      breadcrumbs: [
        {text: "Tagihan SPP", to: "/tagihan-spp", disabled: false, exact: true},
        {text: "Ubah", disabled: true},
      ],
      btnSaveDisable: false,
      message: "",
      tahun_ajaran: [],
      status: ["Berhasil", "Pending", "Gagal"],
      form: {
        id: 0,
        id_ta: 0,
        id_siswa: 0,
        id_pembayaran: 0,
        kode_transaksi: "",
        tgl_pembayaran: "",
        status: "",
      },
      rules: {
        kode_transaksi: [(v) => !!v || this.$t("FIELD_IS_REQUIRED", {field: "Kode Transaksi"})],
        tgl_pembayaran: [(v) => !!v || this.$t("FIELD_IS_REQUIRED", {field: "Tanggal Pembayaran"})],
        tahun_ajaran: [(v) => !!v || this.$t("FIELD_IS_REQUIRED", { field: "Tahun Ajaran" })],
        status: [(v) => !!v || this.$t("FIELD_IS_REQUIRED", {field: "Status"})],
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
          this.$axios.$put("/transaksi", this.form)
              .then((res) => {
                this.$router.push({
                  name: `transaksi___${this.$i18n.locale}`,
                  params: {
                    type: "success",
                    message: "UPDATE_SUCCESS",
                    title: this.form.kode_transaksi,
                  },
                });
              })
              .catch((err) => {
                this.$router.push({
                  name: `transaksi___${this.$i18n.locale}`,
                  params: {
                    type: "error",
                    message: "UPDATE_FAILED",
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
    },
    getData() {
      try {
        this.$axios.$get(`/transaksi/${this.id}`)
            .then((res) => {
              const {data} = res;

              this.form.kode_transaksi = data.kode_transaksi
              this.form.tgl_pembayaran = data.tgl_pembayaran
              this.form.status = data.status
              this.form.id_pembayaran = data.id_pembayaran
              this.form.id_siswa = data.id_siswa
              this.form.id_ta = data.id_ta
            })
      } catch (error) {
        console.error('Error:', error);
      }
    },
    getTahunAjaran() {
      this.isLoading = true;

      this.$axios
          .$get(`/tahun-ajaran?page=-1&limit=-1&search=`)
          .then((response) => {
            const { data } = response;

            data.forEach(item => {
              this.tahun_ajaran.push({
                text: item.periode,
                value: item.id,
              })
            })
          })
          .catch((error) => {
            console.log(error);
          })
          .finally(() => {
            this.isLoading = false;
          });
    },
  },
  async mounted() {
    await this.getTahunAjaran();
    this.getData();
  },
};
</script>
