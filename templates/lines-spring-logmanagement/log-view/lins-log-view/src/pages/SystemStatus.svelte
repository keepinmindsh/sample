<script>
    import Datepicker from 'svelte-calendar';

</script>


<div class="tm-section-wrap">
    <section id="intro" class="row tm-section" >

        <div class="container">

            <div class="mb-3 row">
                <label for="serverList" class="visually-hidden">서버</label>
                <div class="col-sm-3">
                    <input class="form-control" list="datalistOptions" id="serverList" placeholder="Type to search...">
                    <datalist id="datalistOptions">
                        <option value="San Francisco">
                        <option value="New York">
                        <option value="Seattle">
                        <option value="Los Angeles">
                        <option value="Chicago">
                    </datalist>
                </div>
                <label for="userId" class="visually-hidden">사용자</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" id="userId">
                </div>
            </div>
            <div class="row">
                <div class="col-sm">
                    <div class="row">
                        로그 관리 항목
                    </div>
                    <div class="row">
                        <ul class="list-group">
                            <li class="list-group-item active">Cras justo odio</li>
                            <li class="list-group-item">Dapibus ac facilisis in</li>
                            <li class="list-group-item">Morbi leo risus</li>
                            <li class="list-group-item">Porta ac consectetur ac</li>
                            <li class="list-group-item">Vestibulum at eros</li>
                        </ul>
                    </div>
                </div>
                <div class="col-sm">
                    <div class="row">
                        로그 일자
                    </div>
                    <div class="row">
                        <Datepicker  />
                    </div>
                </div>
                <div class="col-sm">
                    <div class="row">
                        검색조건
                    </div>
                    <div class="row">
                        <div class="row">
                        <button type="button" class="btn btn-secondary">검색 </button>
                        </div>
                        <div class="row">
                            <div class="md-form">

                            </div>
                            <div class="md-form">

                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">

                <div class="col">cosdfsdfsdfl
                </div>
                <div class="w-100"></div>
                <div class="col">cosdfsdfsdfl
                </div>
                <div class="w-100"></div>
                <div class="col-sm-2">
                    Level 1: .col-sm-3
                </div>
                <div class="col-sm-10">
                    <div class="row">
                        <div class="col-4 col-sm-6">
                            <div class="tm-bg-white-transparent tm-intro">
                                <h2 class="tm-section-title mb-5 text-uppercase tm-color-primary">Introducing Dream Pulse</h2>
                                <p class="tm-color-gray">
                                    This box alpha 30 percent. Left sidebar is a sticky element.
                                    Right side Contents are scrolling up and down. This background has a
                                    parallax effect.
                                </p>
                                <p class="mb-0 tm-color-gray">
                                    Dream Pulse is a Bootstrap 4.3.1 template designed for your websites. You can modify this layout as you like.
                                </p>
                            </div>
                        </div>
                        <div class="col-8 col-sm-6">
                            Level 2: .col-4 .col-sm-6
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>
