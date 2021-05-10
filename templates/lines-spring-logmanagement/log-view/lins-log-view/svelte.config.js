// svelte.config.js
const sveltePreprocess = require('svelte-preprocess')
const production = !process.env.ROLLUP_WATCH;

module.exports = {
    // enable run-time checks when not in production
    dev: !production,
    // we'll extract any component CSS out into
    // a separate file - better for performance
    css: css => {
        css.write('public/build/bundle.css');
    },
    installOptions: {
        rollup: { plugins: [require('rollup-plugin-svelte')()] }
    },
    preprocess: sveltePreprocess({
        sourceMap: !production
    }),
}
