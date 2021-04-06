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
    };

    const logPaths = [
        "91_NextCMS_Log",
        "com",
        "oper01",
        "oper02",
        "pms",
        "spring-boot"
    ];

    const clickLogPath = (event) => {
       const groupList = document.querySelectorAll("li.list-group-item");

        let index = 0, length = groupList.length;
        for ( ; index < length; index++) {
            groupList[index].classList.remove("active");
        }

        event.target.classList.add("active");

        callFolderTree();
    }

    const callFolderTree = () => {
        fetch("http://localhost:7000/file/tree?path=/Users/dream/test/").then((response) => {
                console.log(response);

                response.text().then(function(text) {
                    console.log(text);
                });
            }
        );
    }

    const callOpenFile = () => {
        fetch("http://localhost:7000/file/open?filePath=/Users/dream/test/text.txt").then((response) => {
                console.log(response);

                response.text().then(function(text) {
                    console.log(text);
                });
            }
        );
    }

</script>


<div class="tm-section-wrap">
    <section id="intro" class="row tm-section" >
        <div class="container">
            <div class="mb-3 row">
                <label for="serverList" class="visually-hidden">서버</label>
                <div class="col-sm-3">
                    <input class="form-control" list="datalistOptions" id="serverList" placeholder="서버를 선택해주세요...">
                    <datalist id="datalistOptions">
                        <option value="233">
                        <option value="234">
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
                            {#each logPaths as path}
                                <li class="list-group-item" on:click={clickLogPath} >{path}</li>
                            {/each}
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
