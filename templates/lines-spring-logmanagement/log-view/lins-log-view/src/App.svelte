<script lang="ts">
	 import Nav from './pages/Nav.svelte';
	 import SystemStatus from './pages/SystemStatus.svelte';
	 import Logs from './pages/Logs.svelte';
</script>

<index>
	<main class="container-fluid">
		<div class="row">
			<Nav />

			<main role="main" class="ml-sm-auto col-12">
				<div class="parallax-window"
					 data-parallax="scroll"
					 data-image-src="img/dream-pulse-header.jpg">
					<SystemStatus />
				</div>

				<div class="tm-section-wrap bg-white">
					<Logs />
				</div>

				<div class="tm-section-wrap bg-white">
					<section id="work" class="row tm-section">

					</section>
				</div>

				<div class="tm-section-wrap bg-white">
					<section id="clients" class="row tm-section">

					</section>
				</div>

				<div class="tm-section-wrap bg-white">
					<section id="talk" class="row tm-section">
					</section>
				</div>

			</main>
		</div>
	</main>
</index>

<style>
	index {
		text-align: center;
		padding: 1em;
		max-width: 240px;
		margin: 0 auto;
	}

	@media (min-width: 640px) {
		index {
			max-width: none;
		}
	}
</style>
