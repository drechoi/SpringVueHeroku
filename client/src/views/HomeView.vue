<template>
  <div>
    <p>
      --- this is Debug ---
    </p>
    <p>
      --- this is Current user info ---
    </p>
    <UserInfo user-name="Bartholomew" />
    <p />

    <UserInfo user-name="Caitlyn"/>

    <p>
      --- this is wish list ---
    </p>
    <WishList :todos="$store.state.wish.wishItems" />
  </div>
</template>

<script>
import WishList from '@/components/wishList';
import WishItem from '@/components/wishItem';
import UserInfo from '@/components/UserInfo';

export default {
  components: {
    WishList,
    WishItem,
    UserInfo,
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
