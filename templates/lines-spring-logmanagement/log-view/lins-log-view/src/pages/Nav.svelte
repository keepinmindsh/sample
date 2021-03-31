<script lang="ts" >
    export let logTitle : string = "CMS LOGS";
</script>

<nav id="tmSidebar" class="tm-bg-black-transparent tm-sidebar">
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

        <ul id="tmMainNav" class="nav flex-column text-uppercase text-right tm-main-nav">
            <li class="nav-item">
                <a href="#intro" class="nav-link active">
                    <span class="d-inline-block mr-3">System Status</span>
                    <span class="d-inline-block tm-white-rect"></span>
                </a>
            </li>
            <li class="nav-item">
                <a href="#about" class="nav-link">
                    <span class="d-inline-block mr-3">Logs</span>
                    <span class="d-inline-block tm-white-rect"></span>
                </a>
            </li>
            <li class="nav-item">
                <a href="#work" class="nav-link">
                    <span class="d-inline-block mr-3">미정</span>
                    <span class="d-inline-block tm-white-rect"></span>
                </a>
            </li>
            <li class="nav-item">
                <a href="#clients" class="nav-link">
                    <span class="d-inline-block mr-3">미정</span>
                    <span class="d-inline-block tm-white-rect"></span>
                </a>
            </li>
            <li class="nav-item">
                <a href="#talk" class="nav-link">
                    <span class="d-inline-block mr-3">미정</span>
                    <span class="d-inline-block tm-white-rect"></span>
                </a>
            </li>
        </ul>

        <footer class="text-center text-white small">
            <p class="mb--0 mb-2">Copyright 2021 SanhaIT</p>
            <p class="mb-0">Made by :
                <a rel="nofollow" href="https://templatemo.com" class="tm-footer-link">Sanha RD</a>
            </p>
        </footer>
    </div>
</nav>
