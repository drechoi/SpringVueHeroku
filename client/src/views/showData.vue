<template>
  <div>
    <p>
      <font-awesome-icon icon="coffee" />
      Your Data: {{ $store.getters.someValue }}
    </p>
    <p>
      Store state : {{ $store.state.wish }}
    </p>
    <b-button
      variant="primary">Primary</b-button>

    <div
      v-for="(value, name, index) in object"
      :key="index">
      <b-container>
        <b-card :title="name">
          <b-card-text>{{ value }}</b-card-text>
        </b-card>
      </b-container>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      object: {
        title: 'How to do lists in Vue',
        author: 'Jane Doe',
        publishedAt: '2016-04-10'
      }
    };
  }
};
</script>
