<script setup>
</script>

<template>
  <div>
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
  <div>
    <table>
      <thead>
        <tr>
          <th>Name</th>
          <th>Age</th>
          <th>Title</th>
          <th>Hometown</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(entry, index) in entries" :key="index">
          <td>{{ entry.name }}</td>
          <td>{{ entry.age }}</td>
          <td>{{ entry.title }}</td>
          <td>{{ entry.hometown }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</div>
</template>

<script>
import { onMounted, ref } from 'vue';
import axios from 'axios';

export default {

  setup() {
    const name = ref('');
    const age = ref('');
    const title = ref('');
    const hometown = ref('');
    const entries = ref([
      { name: 'John', age: 30, title: 'Developer', hometown: 'New York' },
      { name: 'Jane', age: 25, title: 'Designer', hometown: 'London' },
      { name: 'Bob', age: 40, title: 'Manager', hometown: 'Paris' }
    ]);

    const fetchEntries = async () => {
  try {
    const response = await axios.get('http://localhost:8080/form'); 
    console.log(response)
    entries.value = response.data; 
  } catch (error) {
    console.error(error);
  }
};


const addEntries = async () => {
  try {
    const response = await axios.post('http://localhost:8080/form', {
    name: name.value,
    age: age.value,
    title: title.value,
    hometown: hometown.value,
  })
    console.log(response)
  }catch (error){
    console.error(error)
  }
}
  
onMounted(fetchEntries)
    const handleSubmit = () => {
      // Check if the required fields are entered
      if (name.value === '' || title.value === '') {
        alert('Name and Title are required fields.');
        return;
      }

      // Add the entry to the table
      const entry = {
        name: name.value,
        age: age.value,
        title: title.value,
        hometown: hometown.value,
      };

      entries.value.push(entry);
      addEntries();
      // Show the confirmation message
      const message = `Name: ${name.value}\nAge: ${age.value}\nTitle: ${title.value}\nHometown: ${hometown.value}`;
      alert(message);


      // Clear the form fields
      name.value = '';
      age.value = '';
      title.value = '';
      hometown.value = '';
     
    };


    return { name, age, title, hometown, handleSubmit, entries };
  },
  
};


</script>
<style scoped>
.container {
  max-width: 500px;
  margin: 0 auto;
  padding: 20px;
  background-color: #080808;
  border-radius: 5px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
}

h1 {
  font-size: 32px;
  margin: 0 auto 20px;
  text-align: center;
}

.form-group {
  margin-bottom: 20px;
}

label {
  display: block;
  font-weight: bold;
  margin-bottom: 5px;
}

input[type="text"] {
  width: 100%;
  padding: 10px;
  border-radius: 5px;
  border: none;
  background-color: #f9f9f9;
  box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
}

input[type="text"]:focus {
  outline: none;
  box-shadow: 0 0 5px rgba(0, 0, 0, 0.2);
}

button[type="submit"] {
  display: block;
  margin-top: 20px;
  padding: 10px 20px;
  border-radius: 5px;
  border: none;
  background-color: #007bff;
  color: #fff;
  font-weight: bold;
  cursor: pointer;
  transition: all 0.3s ease;
}

button[type="submit"]:hover {
  background-color: #0062cc;
}

table {
  border:1px solid;
  width: 100%;
}

th,
td {
  padding: 8px;
  text-align: left;
}

th {
  background-color: #080808;
  color: #fff;
}

tr:nth-child(even) {
  background-color: rgba(0, 0, 0, 0);
}
</style>