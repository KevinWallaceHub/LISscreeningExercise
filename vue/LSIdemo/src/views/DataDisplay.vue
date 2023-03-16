<template>
    <div>
      <h1>Confirmation Page</h1>
      <div class="card">
        <div class="card-body">
          <h2>Thank you for submitting your information!</h2>
          <p>Here's what we got:</p>
          <ul>
            <li><strong>Name:</strong> {{ entry.name }}</li>
            <li><strong>Age:</strong> {{ entry.age }}</li>
            <li><strong>Title:</strong> {{ entry.title }}</li>
            <li><strong>Hometown:</strong> {{ entry.hometown }}</li>
          </ul>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    computed: {
      entry() {
        return this.$store.state.entries[this.$store.state.entries.length - 1];
      },
    },
  };
  </script>