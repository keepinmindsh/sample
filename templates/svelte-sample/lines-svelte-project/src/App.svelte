<script>
	import Navbar from './Navbar.svelte';
	export let name;

	let points = 100;
	let textMessage = "Hi, Mr Jhon";
	let showControls = false;

	const addPoint = () => ( points += 1 );
	const removePoint = () => ( points -= 1);
	const toggleControls = () => (showControls = !showControls );
</script>

<style>
	main {
		text-align: center;
		padding: 1em;
		max-width: 240px;
		margin: 0 auto;
	}

	h3 {
		color: #ff3e00;
		text-transform: uppercase;
		font-size: 1em;
		font-weight: 100;
	}

	@media (min-width: 640px) {
		main {
			max-width: none;
		}
	}
</style>

<Navbar />
<main>
	<h3>Hello ~~ {name}!

		<button class="btn btn-sm" on:click={toggleControls} >+</button>
		{#if showControls}-{:else}+{/if}
	</h3>
	<h3>{points}</h3>
	<h3>{textMessage}</h3>
	{#if showControls}
		<button class="btn" on:click={addPoint} >+1</button>
		<button class="btn btn-dark" on:click={removePoint} >-1</button>
		<hr>
		<input type="number" bind:value={points} >
	{/if}
</main>



