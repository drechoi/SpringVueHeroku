<template>
  <div>
    <wishList :todos="$store.state.wish.wishItems" />
  </div>
</template>

<script>
import WishList from '@/components/wishList';
import WishItem from '@/components/wishItem';

export default {
  components: {
    WishList,
    WishItem,
  },
  computed: {
  },
  methods: {
    handleOk(bvModalEvt) {
      // Prevent modal from closing
      alert('handle ok!' + this.name);
    },
    handleSubmit() {
      alert('handle submit!');
    }
  }
};
</script>
