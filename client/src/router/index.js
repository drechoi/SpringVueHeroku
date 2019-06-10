import Vue from 'vue';
import Router from 'vue-router';
import auth from '@/auth/authService';

import HelloWorld from '@/components/HelloWorld';
import DebugView from '@/views/DebugView';
import PageNotFound from '@/views/NotFound';
import Callback from '@/components/Callback';

Vue.use(Router);

const router = new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/callback',
      name: 'callback',
      component: Callback
    },
    {
      path: '/debug',
      component: DebugView
    },
    {
      path: '*',
      component: PageNotFound
    }
  ]
});

var debug = true;
router.beforeEach((to, from, next) => {
  if (debug) return next();

  if (to.path === '/' || to.path === '/home' || to.path === '/callback' || auth.isAuthenticated()) {
    return next();
  }

  // Specify the current path as the customState parameter, meaning it
  // will be returned to the application after auth
  auth.login({ target: to.path });
});

// Existing export
export default router;
