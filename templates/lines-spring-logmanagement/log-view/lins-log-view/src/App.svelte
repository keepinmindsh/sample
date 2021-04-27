<script lang="ts">
	 import Nav from './pages/Nav.svelte';
	 import {Container, Row, Col} from 'sveltestrap';
	 import SystemStatus from './pages/SystemStatus.svelte';
	 import Logs from './pages/Logs.svelte';
</script>

<index>
	<Container fluid>
		<Row>
			<Col md='3'>
				<Nav/>
			</Col>
				
			<Col md='9 pl-0'>
				<SystemStatus/>
			</Col>
		</Row>
	</Container>
	
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
