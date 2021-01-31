<script>
	export let name;

	let title = "선언적 렌더링";
	let second = 0;

	setTimeout(() => {
		title = "30초 뒤에 변경된 값";
		second = 30;

	}, 3000)

	function assign() {
		title = "assign 함수가 실행되었을 때, ";
		second = 500;
	}

	let src = "./link.png";


</script>

<main>
	<h1>Svelte Study - {name}!</h1>
	<!-- 중괄호를 이용한 선언적 렌더링 -->
	<h2 class={second < 100 ? 'active' : '' } >
		{second}
	</h2>

	<hr>
</main>
<main-content>
	{title}
	<div class="main-box" >
		<span>Set Timeout에 의해 변화 : </span><span>{second}</span>
		<br>
		<br>
		<!-- 단항뱡 처리의 경우  -->
		<input type="number" value={second} /><button on:click={assign}  >단방향 바인딩 할당 합니다.</button>
		<br><br>
		<!-- 양방향 처리의 경우 -->
		<input type="number" bind:value={second} />
	</div>

	<img {src} alt="Sample">
	
</main-content>



<style>

	.main-box {
		text-align: left;
		padding: 1em;
	}

	main {
		text-align: center;
		padding: 1em;
		max-width: 240px;
		margin: 0 auto;
	}

	main-content {
		text-align: left;
		padding: 1em;
	}

	h1 {
		color: #ff3e00;
		text-transform: uppercase;
		font-size: 4em;
		font-weight: 100;
	}

	.active {
		color: red;
	}

	@media (min-width: 640px) {
		main {
			max-width: none;
		}
	}
</style>