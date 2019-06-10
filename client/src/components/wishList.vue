<template>
  <div>
    <b-dropdown
      id="dropdown-1"
      text="Filter"
      class="m-md-2">
      <b-dropdown-item>Filter</b-dropdown-item>
    </b-dropdown>
    <b-card-group deck>
      <createWishItem />
      <wishItem v-for="todo in items" :key="todo.id" :item="todo" />
    </b-card-group>

    <p>Completed Tasks: {{ items.filter(todo => { return todo.done === true }).length }}</p>
    <p>Pending Tasks: {{ items.filter(todo => { return todo.status === 'New' }).length }}</p>
  </div>
</template>

<script>
import wishItem from '@/components/wishItem';
import createWishItem from '@/components/createWishItem';

export default {
  components: { wishItem, createWishItem },
  props: {
    todos: {
      type: Array,
      default: null,
    },
    items: {
      type: Array,
      default: null,
    }
  },
};
</script>
