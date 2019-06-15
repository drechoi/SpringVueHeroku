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
    {{ $store.state.wish.wishItems }}
    <WishList :todos="$store.state.wish.wishItems" />

    <p>
    --- env api root variables ---<br/>>
    {{ rootApi }}<br/>>
    --- env api root variables ---<br/>>
    </p>
  </div>
</template>

<script>
import WishList from '@/components/wishList';
import WishItem from '@/components/wishItem';
import UserInfo from '@/components/UserInfo';

export default {
  mounted() {
    console.log(process.env.ROOT_API);
  },
  components: {
    WishList,
    WishItem,
    UserInfo,
  },
  data() {
    return {
      rootApi: process.env.ROOT_API
    };
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
