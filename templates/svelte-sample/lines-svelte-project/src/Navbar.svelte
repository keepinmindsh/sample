<script>
    let name = 'world'
    let age = 85
    function assign() {
      name = 'Heropy'
      age = 36
    }
</script>

<div class="navbar bg-primary">
    <h1> Player Scoreboard</h1>
</div>

<h1>Hello {name}!</h1>

<h2 class={age < 85 ? 'active': ''}>
  {age}
</h2>

<button on:click={assign}>
    Assign
  </button>