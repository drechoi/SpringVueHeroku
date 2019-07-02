<template>
  <div>
    <p>
      --- this is Debug ---
      is log in: {{ $store.state.localAuth }}
      <b-button @click="login">Login</b-button>
      <b-button @click="logout">Logout</b-button>
      <a href="/">#</a>

      {{ updateLocalStorage() }}
    </p>
    <div>
      <Achievement :title="dummy" :type="daily" :star="3"/>
    </div>
    <div>
      --- this is Current user info 1 ---
      {{todo}}
      <b-button @click="getTodoTest">getTodo</b-button>
      <p>
        msg: {{ this.msg }}
      </p>
    </div>
  </div>
</template>

<script>
import WishList from '@/components/wishList';
import WishItem from '@/components/wishItem';
import UserInfo from '@/components/UserInfo';
import Achievement from '@/components/Achievement';

// import DemoService from '@/services/api/DemoService';
// import axios from 'axios';
import Api from '@/services/api/Api';

const localStorageKey = 'tmp_local_storage_key';
export default {
  components: {
    WishList,
    WishItem,
    UserInfo,
    Achievement,
  },
  data() {
    return {
      todo: null,
      msg: '',
    };
  },
  computed: {
  },
  methods: {
    async getTodoTest() {
      // const response = await DemoService.getTodo({ id: 1 });
      // this.todo = response.data.result[0];
      Api().post('user/login',
        {
          extId: '123',
          userName: 'test1234',
        })
        .then(response => {
          console.log('then');
          console.log(response.data);
          this.todo = response.data;
        })
        .catch(error => {
          this.msg = error;
          console.log(error);
        })
        .finally(() => {
          // this.msg += 'finally';
          // console.log('finally');
        });
    },
    handleOk(bvModalEvt) {
      // Prevent modal from closing
      alert('handle ok!' + this.name);
    },
    handleSubmit() {
      alert('handle submit!');
    },
    login() {
      console.log('component login');
      this.$store.dispatch('login');
      // this.$auth.login();
    },
    logout() {
      this.$store.dispatch('logout');
    },
    updateLocalStorage() {
      if (localStorage.getItem(localStorageKey) == null) {
        localStorage.setItem(localStorageKey, 1);
        return 1;
      } else {
        let tmp = localStorage.getItem(localStorageKey);
        tmp = tmp + 1;
        localStorage.setItem(localStorageKey, tmp);
        return tmp;
      }
    },
    renewToken() {
      try {
        this.$auth.renewTokens();
      } catch (e) {
        console.log(e);
      }
    }
  }
};
</script>
