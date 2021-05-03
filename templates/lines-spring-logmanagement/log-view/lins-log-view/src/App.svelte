<script lang="ts" href="https://unpkg.com/mdbsvelte@latest/dist/mdbsvelte.js">
	import Nav from './pages/Nav.svelte';
	import {MDBContainer, MDBRow, MDBCol} from "mdbsvelte";
	import SystemStatus from './pages/SystemStatus3.svelte';

	const hostUrl = "http://localhost:7000";
    const logData1 = [
        {title:"91_NextCMS_Log",path:"C:/Users/ekdldksp12/Desktop/산하정보기술/네이트온", active: false},
        {title:"com", path:"D:/boot-workspace/WINGS-API-CMS/08_WingsCMS_Distributed", active: false},
        {title:"oper01", path:"D:/boot-workspace/WINGS-API-CMS/11_WingsCMS", active: false},
        {title:"oper02", path: "D:/boot-workspace/WINGS-API-CMS/21_OTA", active: false},
        {title:"pms", path: "D:/boot-workspace/WINGS-API-CMS/99_Cloud", active: false},
        {title:"spring-boot", path: "D:/boot-workspace/WINGS-API-CMS", active: false}
    ];

    
    const logData2 = [
        {title:"NextCMS_Log2",path:"C:/Users/ekdldksp12/Desktop/산하정보기술/네이트온", active: false},
        {title:"com2", path:"D:/boot-workspace/WINGS-API-CMS/08_WingsCMS_Distributed", active: false},
        {title:"oper03", path:"D:/boot-workspace/WINGS-API-CMS/11_WingsCMS", active: false},
        {title:"oper04", path: "D:/boot-workspace/WINGS-API-CMS/21_OTA", active: false},
        {title:"pms2", path: "D:/boot-workspace/WINGS-API-CMS/99_Cloud", active: false},
        {title:"spring-boot2", path: "D:/boot-workspace/WINGS-API-CMS", active: false}
    ];

    const serverData = [
        ["WAS7", [...logData1]],
        ["WAS8", [...logData2]],
    ];
</script>

<index>
	<MDBContainer fluid>
		<MDBRow>
			<MDBCol md='3'>
				<Nav/>
			</MDBCol>
			<MDBCol md='9 pl-0'>
				<SystemStatus hostUrl={hostUrl} serverData={serverData}/>
			</MDBCol>
		</MDBRow>
	</MDBContainer>
</index>

<style>
	index {
		text-align: center;
		padding: 1em;
		max-width: 240px;
		margin: 0 auto;
	}

	@media (min-width: 640px) {
		index {
			max-width: none;
		}
	}
</style>
