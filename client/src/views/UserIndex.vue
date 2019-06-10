<template>
  <div>
    <p>User Index</p>

    <router-link v-for="user in users" :key="user.id" :to="'/user/' + user.id">
      <user-info :name="user.name" :status="user.status" />
    </router-link>

    <b-container>
      ---- feed ----
    </b-container>
  </div>
</template>

<script>
import UserInfo from '@/components/UserInfo';

export default {
  components: {
    UserInfo,
  },
  data() {
    return {
      users: [
        { id: '123', name: 'Caitlyn', state: { tmp: 'hi' } },
        { id: '234', name: 'Bartholomew', state: { tmp: 'yo' } },
      ],
    };
  },
};
</script>
