<script>
    import Datepicker from 'svelte-calendar';

    let tree = [];
    let fileList = [];
    let hostUrl = "http://localhost:7000";
    let fileContent = "";
    let fileTitle = "";

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

    const callFolderTree = (itemPath, isParent) => {

        let path = itemPath ? itemPath : "/Users/dream/test/";

        callFileList(itemPath);

        fetch(`${hostUrl}/file/tree?path=${path}`).then((response) => {
                console.log(response);

                response.text().then(function(text) {
                    console.log(text);

                    console.log("Success:", );

                    tree = JSON.parse(text);
                });
            }
        );
    }

    const callFileList = (itemPath) => {
        fetch(`${hostUrl}/file/lists?path=${itemPath}`).then((response) => {
                console.log(response);

                response.text().then(function(text) {
                    console.log(text);

                    fileList = JSON.parse(text);
                });
            }
        );
    }

    const callOpenFile = (filePath, fileName) => {
        fetch(`${hostUrl}/file/open?filePath=${filePath}`).then((response) => {
                console.log(response);

                response.text().then(function(text) {
                    fileTitle = fileName;
                    fileContent = text;
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
                <div class="w-100"></div>
                <div class="col-sm-4 border-all-line mt-1 text-left">
                    <div class="list-group">
                        {#each tree as treeItem}
                            <button type="button" value="{treeItem.path}" on:click={() => { callFolderTree(treeItem.path, treeItem.isParent); }} class="list-group-item list-group-item-action">
                                {treeItem.label}
                                {#if treeItem.hasChild}
                                    <span class="badge bg-primary rounded-pill">V</span>
                                {:else}
                                {/if}
                            </button>
                        {/each}
                    </div>
                </div>
                <div class="col-sm-8 border-all-line mt-1">
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th scope="col">FileName</th>
                                <th scope="col">Process</th>
                                <th scope="col">CreationTime</th>
                            </tr>
                        </thead>
                        <tbody>
                            {#each fileList as file}
                                <tr>
                                    <td> {file.fileName}</td>
                                    <td> <button type="button" class="btn btn-primary grid-button" on:click={() => {callOpenFile(file.filePath, file.fileName)}} >Open</button></td>
                                    <td> {file.createdDate}</td>
                                </tr>
                            {/each}
                        </tbody>
                    </table>
                </div>

            </div>
            <div class="card">
                <div class="card-header">
                    CMS Log Content
                </div>
                <div class="card-body">
                    <h5 class="card-title log-align ">{fileTitle}</h5>
                    <p class="card-text log-align ">
                        {@html fileContent}
                    </p>
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

    .grid-button {
        line-height: 0.5 !important;
    }

    .log-align {
        text-align: left !important;
    }

    .w-239 {
        width: 239px;
    }
</style>
