<template>
  <div>
    <div class='item1'>item1</div>
    <div class='item2'>item2</div>

  </div>
</template>
<script>
export default {
  data() {
    return {
      myMessage: 'My message goes here'
    };
  }
};
</script>
<style lang="scss" scoped>

$base-color1: #aaffaa;
$base-color2: #ffaaaa;
$text-color: #003300;

@mixin item($bg-color, $color) {
  color: $color;
  background-color: $bg-color;
}

.item1 {
  @include item($base-color1, $text-color);
}

.item2 {
  @include item($base-color2, $text-color);
}
</style>
