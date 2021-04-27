<script lang="ts" defer src="https://use.fontawesome.com/releases/v5.3.1/js/all.js">
    import { Col, Row} from 'sveltestrap';
    export let logTitle : string = "CMS LOGS";

    interface NavItem {
        title : string;
        key : string;
    }

    export let navItems : NavItem[] =
        [
            { title : "System Status ", key : "intro" },
            { title : "Logs ", key : "about" }
        ]
</script>

<nav id="tmSidebar" class="tm-sidebar">
    <button class="navbar-toggler" type="button" aria-label="Toggle navigation">
        <i class="fas fa-bars"></i>
    </button>
    <div class="tm-sidebar-sticky">
        <div class="tm-brand-box">
            <div class="tm-double-border-1">
                <div class="tm-double-border-2">
                    <h1 class="tm-brand text-uppercase">{logTitle}</h1>
                </div>
            </div>
        </div>
        <br><br>
        <ul id="tmMainNav" class="nav flex-column text-uppercase text-right tm-main-nav">

            {#each navItems as item, i}
                <li class="nav-item">
                    <a href="#{item.key}" class="nav-link active">
                        <span class="d-inline-block mr-3">{item.title}</span>
                        <span class="d-inline-block tm-white-rect"></span>
                    </a>
                </li>
            {/each}

        </ul>

        <footer class="text-center text-white small">
            <p class="mb--0 mb-2">Copyright 2021 SanhaIT</p>
            <p class="mb-0">Made by :
                <a rel="nofollow" style="color:yellow" href="https://templatemo.com" class="tm-footer-link">Sanha RD</a>
            </p>
        </footer>
    </div>
</nav>
