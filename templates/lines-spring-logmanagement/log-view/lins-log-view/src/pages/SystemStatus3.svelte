<script defer src="https://use.fontawesome.com/releases/v5.3.1/js/all.js" 
        href="https://unpkg.com/mdbsvelte@latest/dist/mdbsvelte.js">
    import { onMount } from 'svelte';
    import { FormGroup, Input, Label,CardText, Card, CardBody } from 'sveltestrap';
    import { MDBContainer, MDBRow, MDBCol, MDBBtn, MDBCard, MDBCardBody, MDBBadge, MDBListGroup, MDBListGroupItem} from "mdbsvelte";
    import { Svroller } from 'svrollbar'
    import Datepicker from 'svelte-calendar';
    import { getComparator } from "../utilities/helper.js";
    import "../../public/css/Table.css";
    import "../../public/css/button.css";
    
    export let hostUrl;
    export let serverData;
    
    const columns = ["FileName", "Process", "CreationTime"];
    
    let userId = null;
    let fileList = [];
    let tree = [];    
    let fileTitle = '';
    let fileContent = 'No file selected';
    let logPaths = [];
    let logPathsCopy = [];
    
    $:treeClone = tree;
    $:logPathsClone = [...logPaths]; 
    $:fileTitleClone = fileTitle;
    $:fileContentClone = fileContent;

    let sortColumn = null;
    let sortDirection = null;

    const clickLogPath = (path, index) => {
        fileList = [];

        const groupList = document.querySelectorAll('div.item');
        logPathsCopy = [...logPaths];
        logPaths = [];
        let i = 0, length = groupList.length;
        for ( ; i < length; i++) {
            if(i === index){
                logPathsCopy[i].active = true;
            } else {
                logPathsCopy[i].active = false;
            }
        }
        logPaths = [...logPathsCopy];
        
        callFolderTree(path);
    }

    async function callFolderTreeAsync (itemPath) {
        if(itemPath === '') return [];

        const response = await fetch(`${hostUrl}/file/tree?path=${itemPath+'/'}`);
        const text = await response.text();

        if(response.ok) return JSON.parse(text);
        else throw new Error(text);
    }

    async function callFolderTree (itemPath) {
        console.log('callFolderTree');
        fileList = await callFileList(itemPath);
        console.log(`fileList : ${fileList}`);
        tree = await callFolderTreeAsync(itemPath);
        console.log(`tree : ${tree}`);
    }

    async function callFileList(itemPath) {
        if(itemPath === '') return [];

        const response = await fetch(`${hostUrl}/file/lists?path=${itemPath}`);
        const text = await response.text();

        if(response.ok) return JSON.parse(text);
        else throw new Error(text);
    }

    const callOpenFile = (filePath, fileName) => {
        try {
            fetch(`${hostUrl}/file/open?filePath=${filePath}`).then((response) => {
                    response.text().then(function(text) {
                        fileTitle = fileName;
                        fileContent = text;
                    });
                }
            );
        } catch (error) {
            console.log(`error : ${error}`);
        }
    }

    function sortBy(column) {
    const sameColumn = column === sortColumn;
    const currentlyAscending = sortDirection === "ASC";
    const unsetSort = sameColumn && !currentlyAscending;

    sortColumn = unsetSort ? null : column; 
    sortDirection = unsetSort
      ? null
      : sameColumn && currentlyAscending
      ? "DESC"
      : "ASC";
    }

    const sortData = () => {
        let items = [...fileList];

        if (!fileList.length) return fileList;

        const type = typeof fileList[0][sortColumn.toLowerCase()];

        items.sort(getComparator(type, sortColumn));

        return sortDirection === "ASC" ? items : items.reverse();
    }

    $: display = sortColumn && sortDirection ? sortData() : [...fileList];

    const onChange = (event) => {
        let data = serverData[event.target.value][1];
        console.log(data);
        logPaths = [...data];
        tree = [];
        fileList = [];
    }

    const sort = (column) => {
        return column === sortColumn ? sortDirection : null;
    }

</script>

 <!-- Font Awesome -->
 <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
 <!-- Google Fonts -->
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
 <!-- Bootstrap core CSS -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
 <!-- Material Design Bootstrap -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.16.0/css/mdb.min.css" rel="stylesheet">

<MDBContainer fluid>
    <MDBRow class='mt-3'>
        <MDBCol>
            <div class="shadow-sm mb-3 bg-white rounded">
                <MDBCard>
                    <MDBCardBody>
                        <FormGroup row>
                            <MDBCol sm='4'>
                                <MDBRow class='mt-3'>
                                    <MDBCol sm='2' md={{offset:1}}>
                                        <Label for='server'><div class='label mt-1'>서버</div></Label>
                                    </MDBCol>  
                                    <MDBCol sm='10' md={{size: 8}} class='pl-0'>  
                                        <Input type='select' name='server' id='serverSelect' on:change={(event) => onChange(event)}>  
                                            <option>서버를 선택해주세요</option>
                                            {#each serverData as option, index}
                                                <option value={index}>{option[0]}</option>
                                            {/each}
                                        </Input>
                                    </MDBCol>
                                </MDBRow>
                            </MDBCol>
                            <MDBCol sm='4'>
                                <MDBRow class='mt-3'>
                                    <MDBCol sm='2'>
                                        <Label for='server'><div class='label mt-1'>일자</div></Label>
                                    </MDBCol>  
                                    <MDBCol sm='10' md={{size: 8}} class='pl-0'>  
                                        <Datepicker/>
                                    </MDBCol>
                                </MDBRow>
                            </MDBCol>
                            <MDBCol sm='4'>
                                <MDBRow class='mt-3'>
                                    <MDBCol sm='2' class='pl-1 pr-1'>
                                        <Label for='user'><div class='label mt-1'>사용자</div></Label>
                                    </MDBCol>  
                                    <MDBCol sm='10' md={{size: 8}} class='pl-0'>
                                        <Input 
                                            type='text'
                                            name='user'
                                            id='user'
                                            bind:value={userId}
                                        />    
                                    </MDBCol>
                                </MDBRow>
                            </MDBCol>
                        </FormGroup>
                    </MDBCardBody>
                </MDBCard>
            </div> 
        </MDBCol>
    </MDBRow>
    <MDBRow class='mt-2'>
        <MDBCol sm='3'>
            <div class="shadow-sm mb-2 bg-white rounded">
                <MDBCard>
                    <MDBCardBody>
                        <Label for='list' class='m-auto'><div class='label'>로그 관리 항목</div></Label>
                        <hr/>
                        <div class='overflow-hidden cardBody'>
                            <Svroller width="100%" height="25vh">
                                <MDBListGroup>
                                    {#each logPathsClone as log, index}
                                        <div class="item">
                                            <MDBListGroupItem 
                                                on:click={() => clickLogPath(log.path, index)}
                                                active={log.active === true}    
                                            >{log.title}</MDBListGroupItem>
                                        </div>
                                    {/each}
                                </MDBListGroup >
                            </Svroller>
                        </div>
                    </MDBCardBody>
                </MDBCard>
            </div>
        </MDBCol>
        <MDBCol sm='4' class='pl-0'>
            <div class="shadow-sm mb-2 bg-white rounded">
                <MDBCard>
                    <MDBCardBody>
                    <Label for='list' class='m-auto'><div class='label'>로그 폴더</div></Label>
                    <hr/>
                    <div class='overflow-hidden cardBody'>
                        <Svroller width="100%" height="25vh">
                            <MDBListGroup>
                                <!-- {#if tree.length > 0} -->
                                    {#each treeClone as item}
                                        <div class="folder">
                                            <MDBListGroupItem class="d-flex justify-content-between align-items-center" on:click={() => callFolderTree(item.path)}>{item.label}
                                            {#if item.childCount > 0 }
                                                <MDBBadge color="deep-orange" pill>{item.childCount}</MDBBadge>
                                            {:else}                    
                                                <MDBBadge color="cyan" pill>{item.childCount}</MDBBadge>    
                                            {/if}
                                            </MDBListGroupItem>
                                        </div>
                                    {/each}
                                <!-- {/if} -->
                                <!-- {#await tree}
                                    <div></div>
                                {:then folder}
                                    {#each folder as item}
                                        <div class="folder">
                                            <MDBListGroupItem class="d-flex justify-content-between align-items-center" on:click={() => callFolderTree(item.path)}>{item.label}
                                            {#if item.childCount > 0 }
                                                <MDBBadge color="deep-orange" pill>{item.childCount}</MDBBadge>
                                            {:else}                    
                                                <MDBBadge color="cyan" pill>{item.childCount}</MDBBadge>    
                                            {/if}
                                            </MDBListGroupItem>
                                        </div>
                                    {/each}
                                {/await} -->

                                <!-- {#each tree as items}
                                    {#await callFolderTree(items.path) then item}
                                    <div class="folder">
                                        <MDBListGroupItem class="d-flex justify-content-between align-items-center" on:click={() => callFolderTree(item.path)}>{item.label}
                                        {#if item.childCount > 0 }
                                            <MDBBadge color="deep-orange" pill>{item.childCount}</MDBBadge>
                                        {:else}                    
                                            <MDBBadge color="cyan" pill>{item.childCount}</MDBBadge>    
                                        {/if}
                                        </MDBListGroupItem>
                                    </div>
                                    {/await}
                                {/each} -->
                            </MDBListGroup>
                        </Svroller>
                    </div>
                    </MDBCardBody>
                </MDBCard>
            </div>
        </MDBCol>
        <MDBCol sm='5' class='pl-0'>
            <div class="shadow-sm mb-2 bg-white rounded">
                <MDBCard>
                    <MDBCardBody>
                        <div class='overflow-hidden table'>
                            <Svroller width="100%" height="29.3vh">
                                <table>
                                    <thead>
                                      <tr>
                                        {#each columns as column}
                                          <th>
                                            <button on:click={() => sortBy(column)} data-sort={() => sort(column)}>
                                                {column}
                                            </button>
                                          </th>
                                        {/each}
                                      </tr>
                                    </thead>
                                    <tbody>
                                      {#each display as row}
                                        <tr>
                                          <td class="name"><strong><em>#{row.fileName}</em></strong></td>
                                          <td class="process"><MDBBtn gradient="aqua" on:click={() => callOpenFile(row.filePath, row.fileName)}>Open</MDBBtn></td>
                                          <td class="date"><div class="flex"><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M11,2A10,10,0,1,0,21,12,10,10,0,0,0,11,2Zm0,18a8,8,0,1,1,8-8A8,8,0,0,1,11,20Zm3.1-7.37L12,11.42V7a1,1,0,0,0-2,0v5s0,.08,0,.12a.65.65,0,0,0,.05.2.89.89,0,0,0,.08.17.86.86,0,0,0,.1.16l.16.13.09.09,2.6,1.5a1,1,0,0,0,.5.13,1,1,0,0,0,.5-1.87Z"/></svg>{row.createdDate}</div></td>
                                        </tr>
                                      {/each}
                                    </tbody>
                                </table>
                            </Svroller>
                        </div>
                    </MDBCardBody>
                </MDBCard>
            </div>
        </MDBCol>    
    </MDBRow>
    <br>
    <MDBRow>
        <MDBCol>
            <Card>
                <div id='header' class="rgba-blue-grey-slight svelte-1ddn5yc">
                    <Label for='content'><div class='content' >CMS Log Content</div></Label>
                </div>
                <CardBody>
                    <div class="logContent overflow-hidden">
                        <Svroller width="100%" height="28vh">
                        <CardText>
                            <h5 class="card-title log-align ">{fileTitleClone}</h5>
                            <p class="card-text log-align ">{@html fileContentClone}</p>
                        </CardText>
                        </Svroller>
                    </div>
                </CardBody>
            </Card>
        </MDBCol>    
    </MDBRow>
</MDBContainer>

<style>
   
    .label {
        font-weight: bold;
        color: #777;
    }

    .cardBody {
        height: 25vh !important;
    }

    .table {
        height: 29.3vh !important;
    }

    .content {
		padding-top: 15px;
		font-weight: bold;
		font-size: large;
		text-align: left;
        height: 5vh;
        vertical-align: middle;
	}

    .logContent {
        height: 28vh !important;
    }

    #header {
        width: 100% !important;
        color:#777;
    }

</style>
