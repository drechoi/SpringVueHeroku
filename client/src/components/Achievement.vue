<template>
  <div>
    <b-card
        no-body
        header-tag="header"
        class="mb-2"
        :class="getClass"
        align="left" >
      <div slot="header"
        @click="toggleShowDetails">
        <b-container>
          <b-row>
            <b-col>
              <font-awesome-icon :icon="['fas', 'trophy']" />
              <strong>{{title}}</strong>
            </b-col>
            <b-col align="right">
              <font-awesome-icon
                v-for="index in stars"
                :key="index"
                :icon="['fas', 'star']" />
            </b-col>
          </b-row>
        </b-container>
      </div>
      <b-card-body v-if="showDetails">
        <b-row>
          <b-col>
            <strong>Description:</strong>
          </b-col>
          <b-col>
            Achievement Description
          </b-col>
        </b-row>
      </b-card-body>
    </b-card>
  </div>
</template>
<script>

export default {
  props: {
    title: {
      type: String,
      default: null,
    },
    type: {
      type: String,
      default: null,
    },
    stars: {
      type: Number,
      default: null,
    },
  },
  data() {
    return {
      showDetails: false
    };
  },
  computed: {
    getClass() {
      return 'card-' + this.type;
    }
  },
  methods: {
    toggleShowDetails: function() {
      // console.log("toggle " + this.showDetails);
      this.showDetails = !this.showDetails;
    }
  }
};

</script>
<style lang="scss" scoped>
@mixin card($theme-color) {
  border-color: $theme-color;

  .card-header {
    background-color: $theme-color;
    color: #FFFFFF;
  }
}

.card-adhoc {
  @include card(#EF7A7A);
}

.card-daily {
  @include card(#6AEF6A);
}

</style>
