<script>
    import Datepicker from 'svelte-calendar';
    import TreeView from '../components/TreeView.svelte'

    const tree = {
        label: "USA", children: [
            {label: "Florida", children: [
                    {label: "Jacksonville"},
                    {label: "Orlando", children: [
                            {label: "Disney World"},
                            {label: "Universal Studio"},
                            {label: "Sea World"},
                        ]},
                    {label: "Miami"},
                ]},
            {label: "California", children: [
                    {label: "San Francisco"},
                    {label: "Los Angeles"},
                    {label: "Sacramento"},
                ]},
        ],
    }

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
            <hr />
            <div class="row">
                <div class="col-sm border-all-line">
                    <div class="row p-1">
                        로그 관리 항목
                    </div>
                    <div class="row p-1">
                        <ul class="list-group">
                            <li class="list-group-item active">Cras justo odio</li>
                            <li class="list-group-item">Dapibus ac facilisis in</li>
                            <li class="list-group-item">Morbi leo risus</li>
                            <li class="list-group-item">Porta ac consectetur ac</li>
                            <li class="list-group-item">Vestibulum at eros</li>
                        </ul>
                    </div>
                </div>
                <div class="col-sm border-all-line">
                    <div class="row p-1">
                        로그 일자
                    </div>
                    <div class="row">
                        <div class="col text-left">
                            <Datepicker  />
                        </div>
                        <div class="w-100"></div>
                        <div class="col">
                        </div>

                    </div>
                </div>
                <div class="col-sm border-all-line">
                    <div class="row p-1">
                        검색조건
                    </div>
                    <div class="row">
                        <div class="col text-left">
                            <button class="w-50" >검색</button>
                        </div>
                        <div class="w-100"></div>
                        <div class="col text-left mt-2">
                            <div class="md-form">
                                <label for="timePeriodStart" class="mr-1" >수정 시간</label><input id="timePeriodStart" type="time" > ~ <input id="timePeriodEnd" type="time" >
                            </div>
                            <div class="md-form">
                                <label for="searchContent" class="mr-1" >수정 내용</label><input type="text" id="searchContent" class="w-239" >
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <hr />
            <div class="row">

                <div class="col border-all-line">
                    box 1
                </div>
                <div class="w-100"></div>
                <div class="col mt-1 ">
                    <div class="row border-all-line" >
                        <div class="col-sm-4">
                            Level 1: .col-sm-3
                        </div>
                        <div class="col-sm-4">
                            Level 1: .col-sm-3
                        </div>
                        <div class="col-sm-4">
                            Level 1: .col-sm-3
                        </div>
                    </div>
                </div>
                <div class="w-100"></div>
                <div class="col-sm-4 border-all-line mt-1 text-left">
                    <TreeView {tree} />
                </div>
                <div class="col-sm-8 border-all-line mt-1">
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">First</th>
                                <th scope="col">Last</th>
                                <th scope="col">Handle</th>
                            </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <th scope="row">1</th>
                            <td>Mark</td>
                            <td>Otto</td>
                            <td>@mdo</td>
                        </tr>
                        <tr>
                            <th scope="row">2</th>
                            <td>Jacob</td>
                            <td>Thornton</td>
                            <td>@fat</td>
                        </tr>
                        <tr>
                            <th scope="row">3</th>
                            <td>Larry the Bird</td>
                            <td>Thornton</td>
                            <td>@twitter</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </section>
</div>

<style>
    .border-all-line{
        border : solid 1px;
    }

    .table td, .table th {
        padding: 0.15rem;
        vertical-align: top;
    }

    .col-sm-8, .col-sm-4 {
        position: relative;
        width: 100%;
        padding-right: 0px;
        padding-left: 0px;
    }

    .table {
        width: 100%;
        margin-bottom: 0px;
        color: #212529;
    }

    .w-239 {
        width: 239px;
    }
</style>
