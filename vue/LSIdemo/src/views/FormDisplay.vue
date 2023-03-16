<script setup>
</script>

<template>
  <div class="container">
    <h1>User Information</h1>
    <form @submit.prevent="handleSubmit">
      <div class="form-group">
        <label for="name">Name*</label>
        <input type="text" id="name" class="form-control" v-model="name" required />
      </div>
      <div class="form-group">
        <label for="age">Age</label>
        <input type="text" id="age" class="form-control" v-model="age" />
      </div>
      <div class="form-group">
        <label for="title">Title*</label>
        <input type="text" id="title" class="form-control" v-model="title" required />
      </div>
      <div class="form-group">
        <label for="hometown">Hometown</label>
        <input type="text" id="hometown" class="form-control" v-model="hometown" />
      </div>
      <button type="submit" class="btn btn-primary">Submit</button>
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      name: '',
      age: '',
      title: '',
      hometown: '',
    };
  },
  methods: {
    handleSubmit() {
      // Check if the required fields are entered
      if (this.name === '' || this.title === '') {
        alert('Name and Title are required fields.');
        return;
      }

      // Add the entry to the table
      const entry = {
        name: this.name,
        age: this.age,
        title: this.title,
        hometown: this.hometown,
      };
      this.$store.commit('addEntry', entry);

      // Show the confirmation message
      const message = `Name: ${this.name}\nAge: ${this.age}\nTitle: ${this.title}\nHometown: ${this.hometown}`;
      alert(message);

      // Clear the form fields
      this.name = '';
      this.age = '';
      this.title = '';
      this.hometown = '';
    },
  },
};
</script>
