<template>
  <b-card style="max-width: 20rem;" class="mb-2">
    <h4 slot="header"> Create A new wish</h4>
    <div slot="footer">
      <b-button variant="primary" @click="create">New</b-button>
    </div>
    <label><strong>Name</strong></label>
    <b-form-input v-model="name" placeholder="Enter a name" />

    <label><strong>Description</strong></label>
    <b-form-input v-model="description" placeholder="Enter a description" />

    <label><strong>Remarks</strong></label>
    <b-form-input v-model="remarks" placeholder="Enter a remarks (optional)" />

    <p>
      --- Debug panel ---
      <ul>
        <li>text: {{ text }}</li>
        <li>Name: {{ name }}</li>
        <li>Description: {{ description }}</li>
      </ul>
    </p>
  </b-card>
</template>

<script>
export default {
  props: {
    name: {
      type: String,
      default: null,
    }
  },
  data() {
    return {
      text: '123',

      title: null,
      description: null,
      remarks: null,
    };
  },
  methods: {
    create: () => {
      alert('hi');
    }
  }
};
</script>
