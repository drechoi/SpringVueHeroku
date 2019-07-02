<template>
  <div>
    <b-container class="c1">
      <UserInfo name="123" />
    </b-container>
    <b-container class="bv-example-row">
      <b-row>
        <b-col class="c2">
          <p>---Wish list ---</p>
          <WishList :items="wishList"/>
          <p>---End of Wish list ---</p>
        </b-col>
        <b-col>
          <p class="c3">Task List & history?</p>
          <b-card>Some stats -- completed - 2, pending - 3</b-card>
          <b-card v-for="task in taskList" :key="task.title">
            Task!
          </b-card>
        </b-col>
        <b-col>
          <p class="c3">Special Rewards</p>
          <b-card>Items Count - 99</b-card>
          <b-card v-for="task in taskList" :key="task.title">
            Task!
          </b-card>
        </b-col>
      </b-row>
    </b-container>
  </div>
</template>
<script>
import UserInfo from '@/components/UserInfo';
import WishList from '@/components/wishList';

export default {
  components: {
    UserInfo,
    WishList,
  },
  data() {
    return {
      user: null,
      wishList: [{title: 'item1'}, {title: 'item2'}],
      taskList: [{title: 'item1'}, {title: 'item2'}],
    };
  },
};
</script>

<style scoped>
.c1 {
  background-color: #880088;
}
.c2 {
  background-color: #888800;
}
.c3 {
  background-color: #008888;
}
</style>
