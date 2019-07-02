import Vue from 'vue';
import Router from 'vue-router';

import Home from '@/views/HomeView';
import DebugView from '@/views/DebugView';
import PageNotFound from '@/views/NotFound';
import Callback from '@/components/Callback';
import Profile from '@/views/Profile';

import {store} from '@/store/store';

Vue.use(Router);

const router = new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home
    },
    {
      path: '/callback',
      name: 'callback',
      component: Callback
    },
    {
      path: '/profile',
      name: 'profile',
      component: Profile,
      meta: { requiresAuth: true }
    },
    {
      path: '/debug',
      component: DebugView,
      meta: { requiresAuth: true }
    },
    {
      path: '*',
      component: PageNotFound
    }
  ]
});

var debug = false;
router.beforeEach((to, from, next) => {
  if (debug) return next();

  console.log(to);
  console.log(to.matched);
  console.log(to.matched.length);

  if (to.matched.some(record => record.meta.requiresAuth)) {
    if (store.state.auth.loggedIn) {
      return next();
    } else {
      store.dispatch('login', { target: to.path });
    }
  } else {
    return next();
  }
  // if (to.path === '/' || to.path === '/home' || to.path === '/callback' || store.state.auth.loggedIn) {
  //   return next();
  // }

  // Specify the current path as the customState parameter, meaning it
  // will be returned to the application after auth
  // auth.login({ target: to.path });
  // store.dispatch('login', { target: to.path });
});

// Existing export
export default router;
