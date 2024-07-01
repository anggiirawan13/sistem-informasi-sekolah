<template>
  <v-row>
    <!-- Input Fields -->
    <v-col cols="10" offset="1">
      <v-card class="mb-2">
        <v-toolbar color="primary" dark>TAMBAH TAHUN AJARAN</v-toolbar>
        <v-card-text>
          <v-alert v-if="message" color="red lighten-2" dark>{{ $t(message) }}</v-alert>
          <v-breadcrumbs :items="breadcrumbs" class="pa-0"></v-breadcrumbs>
          <v-form ref="form">
            <v-text-field
                name="periode"
                label="Periode"
                type="year"
                :rules="rules.periode"
                v-model="form.periode"
            />
            <v-text-field
                name="tgl_mulai"
                label="Tanggal Mulai"
                type="date"
                :rules="rules.tgl_mulai"
                v-model="form.tgl_mulai"
            />
            <v-text-field
                name="tgl_akhir"
                label="Tanggal Akhir"
                type="date"
                :rules="rules.tgl_akhir"
                v-model="form.tgl_akhir"
            />
            <v-text-field
                name="kurikulum"
                label="Kurikulum"
                type="text"
                :rules="rules.kurikulum"
                v-model="form.kurikulum"
            />
          </v-form>
        </v-card-text>
        <v-card-actions>
          <v-btn to="/tahun-ajaran" color="secondary">Back</v-btn>
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
    title: "Tambah Tahun Ajaran",
  },
  data() {
    return {
      breadcrumbs: [
        { text: "Tahun Ajaran", to: "/tahun-ajaran", disabled: false, exact: true },
        { text: "Tambah", disabled: true },
      ],
      btnSaveDisable: false,
      message: "",
      status: ["Active", "Inactive"],
      form: {
        periode: "",
        tgl_mulai: "",
        tgl_akhir: "",
        kurikulum: "",
      },
      rules: {
        periode: [(v) => !!v || this.$t("FIELD_IS_REQUIRED", { field: "Periode" })],
        tgl_mulai: [(v) => !!v || this.$t("FIELD_IS_REQUIRED", { field: "Tanggal Mulai" })],
        tgl_akhir: [(v) => !!v || this.$t("FIELD_IS_REQUIRED", { field: "Tanggal Akhir" })],
        kurikulum: [(v) => !!v || this.$t("FIELD_IS_REQUIRED", { field: "Kurikulum" })],
      },
    };
  },
  methods: {
    async doSave() {
      this.message = "";

      if (this.$refs.form.validate()) {
        this.btnSaveDisable = true;

        try {
          const requestData = {
            periode: this.form.periode,
            tgl_mulai: this.form.tgl_mulai,
            tgl_akhir: this.form.tgl_akhir,
            kurikulum: this.form.kurikulum,
          };

          await this.$axios.$post('/tahun-ajaran', requestData)
          .then((response) => {
            this.$router.push({
            name: `tahun-ajaran___${this.$i18n.locale}`,
            params: {
              type: "error",
              message: response.messages,
              title: this.form.nama_lengkap,
            },
          });
          });
        } catch (error) {
          console.error('Error:', error);
        } finally {
          this.btnSaveDisable = false;
        }
      }
    },
  }
};
</script>
