<template>
  <v-row>
    <!-- Input Fields -->
    <v-col cols="10" offset="1">
      <v-card class="mb-2">
        <v-toolbar color="primary" dark>TAMBAH SISWA</v-toolbar>
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
          <v-btn to="/siswa" color="secondary">Back</v-btn>
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
    title: "Tambah Siswa",
  },
  data() {
    return {
      breadcrumbs: [
        { text: "Siswa", to: "/siswa", disabled: false, exact: true },
        { text: "Tambah", disabled: true },
      ],
      btnSaveDisable: false,
      message: "",
      status: ["Active", "Inactive"],
      form: {
        nisn: "",
        nama_lengkap: "",
        tanggal_lahir: "",
        alamat: "",
        nama_ortu: "",
        telp: "",
        status: "",
      },
      rules: {
        nisn: [(v) => !!v || this.$t("FIELD_IS_REQUIRED", { field: "NISN" })],
        nama_lengkap: [(v) => !!v || this.$t("FIELD_IS_REQUIRED", { field: "Nama Lengkap" })],
        tanggal_lahir: [(v) => !!v || this.$t("FIELD_IS_REQUIRED", { field: "Tanggal Lahir" })],
        alamat: [(v) => !!v || this.$t("FIELD_IS_REQUIRED", { field: "Alamat" })],
        nama_ortu: [(v) => !!v || this.$t("FIELD_IS_REQUIRED", { field: "Nama Orang Tua" })],
        telp: [(v) => !!v || this.$t("FIELD_IS_REQUIRED", { field: "Nomor Telepon" })],
        foto: [(v) => !!v || this.$t("FIELD_IS_REQUIRED", { field: "Foto" })],
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
          let formData = new FormData();
          formData.append('foto', this.form.foto);

          let siswa = {
            id_ta: 1,
            nisn: this.form.nisn,
            nama_lengkap: this.form.nama_lengkap,
            tanggal_lahir: this.form.tanggal_lahir,
            alamat: this.form.alamat,
            nama_ortu: this.form.nama_ortu,
            telp: this.form.telp,
            status: this.form.status === "Active",
          };

          formData.append('siswa', new Blob([JSON.stringify(siswa)], {
            type: 'application/json'
          }));

          this.$axios.$post("/siswa", formData, {
            headers: {
              'Content-Type': 'multipart/form-data'
            }
          })
              .then((res) => {
                this.$router.push({
                  name: `siswa___${this.$i18n.locale}`,
                  params: {
                    type: "success",
                    message: "ADD_SUCCESS",
                    title: this.form.nama_lengkap,
                  },
                });
              })
              .catch((err) => {
                this.$router.push({
                  name: `siswa___${this.$i18n.locale}`,
                  params: {
                    type: "error",
                    message: "ADD_FAILED",
                    title: this.form.nama_lengkap,
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
