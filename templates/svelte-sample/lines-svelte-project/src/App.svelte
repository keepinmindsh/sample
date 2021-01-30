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
		font-size: 1em;
		font-weight: 100;
	}

	box {
		position: relative;
		height: 600px;
		width: 1200px;
		border: 1px solid red;
	}

	@media (min-width: 640px) {
		main {
			max-width: none;
		}
	}
</style>

<Navbar />
<main>
	<box>
		<h3>Hello ~~ {name.toUpperCase()}!

			<button class="btn btn-sm" on:click={toggleControls} >+</button>
			{#if showControls}-{:else}+{/if}
		</h3>
		<h3>{points}</h3>
		<h3>{textMessage}</h3>
	</box>
	<box>
		{#if showControls}
			<button class="btn" on:click={addPoint} >+1</button>
			<button class="btn btn-dark" on:click={removePoint} >-1</button>
			<hr>
			<input type="number" bind:value={points} >
		{/if}
	</box>

</main>



