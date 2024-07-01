<template>
  <v-row>
    <!-- Input Fields -->
    <v-col cols="10" offset="1">
      <v-card class="mb-2">
        <v-toolbar color="primary" dark>TAMBAH TAGIHANSPP</v-toolbar>
        <v-card-text>
          <v-alert v-if="message" color="red lighten-2" dark>{{ $t(message) }}</v-alert>
          <v-breadcrumbs :items="breadcrumbs" class="pa-0"></v-breadcrumbs>
          <v-form ref="form">
            <v-text-field
                name="nisn"
                label="NISN"
                type="text"
                :rules="rules.nisn"
                v-model="form.nisn"
            />
            <v-text-field
                name="nama_lengkap"
                label="Nama Lengkap"
                type="text"
                :rules="rules.nama_lengkap"
                v-model="form.nama_lengkap"
            />
            <v-text-field
                name="tanggal_lahir"
                label="Tanggal Lahir"
                type="date"
                :rules="rules.tanggal_lahir"
                v-model="form.tanggal_lahir"
            />
            <v-text-field
                name="alamat"
                label="Alamat"
                type="text"
                :rules="rules.alamat"
                v-model="form.alamat"
            />
            <v-text-field
                name="nama_ortu"
                label="Nama Orang Tua"
                type="text"
                :rules="rules.nama_ortu"
                v-model="form.nama_ortu"
            />
            <v-text-field
                name="telp"
                label="Nomor Telepon"
                type="text"
                :rules="rules.telp"
                v-model="form.telp"
            />
            <v-file-input
                name="foto"
                label="Foto"
                :rules="rules.foto"
                v-model="form.foto"
                accept="image/*"
            />
            <v-select
            label="Status"
            :items="status"
            :rules="rules.status"
            v-model="form.status"
            ></v-select>
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
    title: "Tambah TagihanSPP",
  },
  data() {
    return {
      breadcrumbs: [
        { text: "TagihanSPP", to: "/tagihan-spp", disabled: false, exact: true },
        { text: "Tambah", disabled: true },
      ],
      btnSaveDisable: false,
      message: "",
      status: ["Active", "Inactive"],
      form: {
        nisn: "",
        nama_lengkap: "",
      },
      rules: {
        nisn: [(v) => !!v || this.$t("FIELD_IS_REQUIRED", { field: "NISN" })],
        nama_lengkap: [
          (v) => !!v || this.$t("FIELD_IS_REQUIRED", { field: "Nama TagihanSPP" }),
        ],
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
  computed: {
    tableHeaders() {
      return [
        { text: "Mata Kuliah", value: "mata_kuliah" },
        { text: "Nilai", value: "nilai" },
        { text: "Actions", value: "actions", sortable: false },
      ];
    },
  },
  methods: {
    async doSave() {
      this.message = "";

      // Validate form using Vue's built-in validation
      if (this.$refs.form.validate()) {
        this.btnSaveDisable = true;

        try {
          // Prepare data to send to the server
          const requestData = {
            nisn: this.form.nisn,
            nama_lengkap: this.form.nama_lengkap,
            nilai: this.mataKuliahNilai.map(item => ({
              mata_kuliah_id: this.mataKuliahOptions.find(mk => mk.nama === item.mata_kuliah).id,
              nilai: item.nilai
            }))
          };

          // Simulate API call delay
          await new Promise(resolve => setTimeout(resolve, 1000));

          // Example of sending data to the server using Axios
          const response = await this.$axios.post('/tagihan-spp', requestData);

          // Handle response if necessary (e.g., show success message)
          console.log('Response:', response);

          // Reset form and related data
          this.$router.push({
            name: `tagihan_spp___${this.$i18n.locale}`,
            params: {
              type: "error",
              message: response.messages,
              title: this.form.nama_lengkap,
            },
          });
        } catch (error) {
          console.error('Error:', error);
          // Handle error if needed (e.g., show error message)
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
        const response = await this.$axios.get('/tagihan-spp');
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
