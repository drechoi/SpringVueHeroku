// Import Vue and the component being tested
// import Vue from 'vue';
import { mount } from '@vue/test-utils';
// import UserInfo from '@/components/UserInfo';
import AchievementItem from '@/components/Achievement';
// import HelloWorld from '@/components/HelloWorld';

describe('Achievement Item Component', () => {
  it('should be do nothing but provide me cheat sheet', () => {
    const wrapper = mount(AchievementItem, {
      propsData: {
        title: 'test-title',
        type: 'daily',
        stars: 1,
      }
    });
    // wrapper.setData({msg: 'test-msg'});
    // console.log(wrapper);
    console.log(wrapper.html());
    // console.log(wrapper.vm.$data);
    // console.log(wrapper.vm.$props);
    // console.log(wrapper.vm.title);
    // console.log(wrapper.vm.msg);
    expect(wrapper.vm.title).to.equal('test-title');
    expect(wrapper.vm.type).to.equal('daily');
    expect(wrapper.vm.stars).to.equal(1);
    expect(wrapper.vm.title).to.be.a('string');
    expect(wrapper.html()).to.contain('test-title');
  });

  it('should render correct contents', () => {
    const wrapper = mount(AchievementItem, {
      propsData: {
        title: 'test-title',
      }
    });
    // wrapper.setData({msg: 'test-msg'});
    // console.log(wrapper);
    // console.log(wrapper.html());
    // console.log(wrapper.vm.$data);
    // console.log(wrapper.vm.$props);
    // console.log(wrapper.vm.title);
    // console.log(wrapper.vm.msg);

    expect(wrapper.vm.title).to.equal('test-title');
  });

  // it('renders a div', () => {
  //   const wrapper = mount(AchievementItem, {
  //     propsData: {
  //       title: 'test-item'
  //     }
  //   });

  //   console.log(wrapper);
  //   expect(wrapper.props().title).to.be('test-item');
  // });

  // // Inspect the raw component options
  // it('has a created hook', () => {
  //   expect(typeof UserInfo.created).to.be('function');
  //   // expect(UserInfo.created).to.euqal('function')
  // });

  // // Inspect the component instance on mount
  // it('correctly sets the message when created', () => {
  //   const vm = new Vue(UserInfo).$mount();
  //   expect(vm.message).toBe('bye!');
  // });

  // it('should render correct contents', () => {
  //   const Constructor = Vue.extend(UserInfo);
  //   const vm = new Constructor().$mount();
  //   expect(vm.$el.querySelector('.hello h1').textContent)
  //     .to.equal('Welcome to Your Vue.js App');
  // });
});
