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
      selectedMataKuliah: null,
      nilai: "",
      mataKuliahNilai: [],
      mataKuliahOptions: [],
      editedItem: null,
    };
  },
  created() {
    this.getMataKuliahOptions();
  },
  methods: {
    doSave() {
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

          this.$axios.post('/tahun-ajaran', requestData).then((response) => {
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
          this.message = 'Failed to save data. Please try again.';
        } finally {
          this.btnSaveDisable = false;
        }
      }
    },
    addMataKuliahNilai() {
      if (this.selectedMataKuliah && this.nilai) {

        if (this.editedItem) {
          const selectedNamaMataKuliah = this.mataKuliahOptions.find(
              option => option.id === this.selectedMataKuliah.id
          ).nama;
          this.editedItem.mata_kuliah = selectedNamaMataKuliah;
          this.editedItem.nilai = this.nilai;
          this.editedItem = null;
        } else {
          const selectedNamaMataKuliah = this.mataKuliahOptions.find(
              option => option.id === this.selectedMataKuliah
          ).nama;
          this.mataKuliahNilai.push({
            mata_kuliah: selectedNamaMataKuliah,
            nilai: this.nilai,
          });
        }

        this.resetInputFields();
      }
    },
    editMataKuliahNilai(item) {
      this.editedItem = item;

      this.selectedMataKuliah = this.mataKuliahOptions.find(
          mk => mk.nama === item.mata_kuliah
      );

      this.nilai = item.nilai;
    },
    deleteMataKuliahNilai(item) {
      const index = this.mataKuliahNilai.indexOf(item);
      if (index !== -1) {
        this.mataKuliahNilai.splice(index, 1);
      }
    },
    resetForm() {
      this.form.nisn = "";
      this.form.nama_lengkap = "";
      this.mataKuliahNilai = [];
    },
    resetInputFields() {
      this.selectedMataKuliah = null;
      this.nilai = "";
    },
    async getMataKuliahOptions() {
      try {
        const response = await this.$axios.get('/tahun-ajaran');
        if (response.data.success) {
          this.mataKuliahOptions = response.data.data.map(matkul => ({
            id: matkul.id,
            nama: matkul.nama_mata_kuliah,
          }));
        } else {
          console.error('Failed to fetch mata kuliah:', response.data.message);
        }
      } catch (error) {
        console.error('Error fetching mata kuliah:', error);
      }
    },
  },
};
</script>
