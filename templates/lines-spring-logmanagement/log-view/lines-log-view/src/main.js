import App from './App.html';

// TODO - https://v2.svelte.dev/guide 를 이용해서 코딩하기
// TODO - https://heropy.blog/2019/09/29/svelte/
const app = new App({
	target: document.body,
	props: {
		name: 'world'
	}
});

export default app;
