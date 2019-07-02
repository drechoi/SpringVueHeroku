<template>
  <b-container class="main-container pt-3">
    <SchemeInfo />

    <b-row class="mb-2">
      <b-col md="6" lg="4" align-self="end">
        <b-card class="sub-container">
          <h4>Achievements</h4>
          <Achievement title="Dummy" type="daily" :stars="3" />
          <Achievement title="Dummy" type="adhoc" :stars="2" />
          <Achievement title="Dummy" type="daily" :stars="1" />
        </b-card>
      </b-col>
      <b-col md="6" lg="4">
        <b-card class="sub-container">
          Placeholder 1
        </b-card>
      </b-col>
      <b-col md="6" lg="4">
        <b-card class="sub-container">
          Placeholder 2
        </b-card>
      </b-col>
    </b-row>

    --- this is Debug ---
      <DebugItem />

    <p>
      --- this is Current user info 2 ---
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
  </b-container>
</template>

<script>
import WishList from '@/components/wishList';
import WishItem from '@/components/wishItem';
import UserInfo from '@/components/UserInfo';
import Achievement from '@/components/Achievement';
import SchemeInfo from '@/components/SchemeInfo';
import DebugItem from '@/components/testTemplate';

export default {
  mounted() {
    console.log(process.env.ROOT_API);
  },
  components: {
    WishList,
    WishItem,
    UserInfo,
    Achievement,
    SchemeInfo,
    DebugItem,
  },
  data() {
    return {
      rootApi: process.env.ROOT_API,
      shapes: [
        { shape: 'circle' },
        { shape: 'square' },
        { shape: 'triangle', direction: 'up' },
        { shape: 'triangle', direction: 'right' },
        { shape: 'triangle', direction: 'down' },
        { shape: 'triangle', direction: 'left' }
      ]
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

<style scoped>
  .sub-container {
    background-color: #fff;
    height: 100%;
  }

  .main-container{
  }
</style>
